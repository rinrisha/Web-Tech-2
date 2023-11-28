package com.example.demo1.dao.impl;

import com.example.demo1.bean.User;
import com.example.demo1.bean.UserRoles;
import com.example.demo1.dao.UserDao;
import com.example.demo1.exception.DAOException;
import com.example.demo1.factory.ConnectionPoolFactory;
import com.example.demo1.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of UserDao handling user-related database operations.
 */
public class SQLUserDAO implements UserDao {

    private static String RegisterNewUser = "INSERT INTO users (userid, name, password, email, role) values (null,?,?,?,?)";
    private static String CheckIfUserExist = "Select * from users where name = ? and password = ?";
    private static String GetUserId = "Select userid, role from users where name = ?";
    private static String GetAllUsrs = "Select * from users";

    @Override
    public List<User> GetAllUsers() throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet result = null;
        List<User> users = new ArrayList<User>();
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(GetAllUsrs);
            result = statement.executeQuery();
            while (result.next()) {
                User user = new User();
                user.setId(result.getInt(1));
                user.setLogin(result.getString(2));
                user.setPassword(result.getString(3));
                user.setEmail(result.getString(4));
                users.add(user);
            }
        } catch (SQLException e) {
            ConnectionPool.rollbackQuery(connection);
            throw new DAOException("Incorrect request",e);
        } finally {
            try{
                connectionPool.releaseConnection(connection);
                ConnectionPool.closeResultSet(result);
                ConnectionPool.closePreparedStatement(statement);
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }

        return users;

    }

    /**
     * Authenticates a user by login and password.
     * @param login The user's login.
     * @param password The user's password.
     * @return The authenticated user.
     * @throws DAOException if there's an error during authentication.
     */
    @Override
    public User signIn(String login, String password) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet result = null;
        User user = new User();
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(CheckIfUserExist);
            statement.setString(1, login);
            statement.setString(2, password);
            result = statement.executeQuery();
            if (!result.next()) {
                throw new SQLException("Incorrect login or password");
            }

            user.setLogin(login);
            statement = connection.prepareStatement(GetUserId);
            statement.setString(1,login);
            result = statement.executeQuery();
            if (!result.next()) {
                throw new SQLException("Incorrect login or password");
            }else
            {
                user.setId(result.getInt(1));
                user.setRole(result.getString(2));
            }

        } catch (SQLException e) {
            ConnectionPool.rollbackQuery(connection);
            throw new DAOException("Sql error",e);
        } finally {
            try{
                connectionPool.releaseConnection(connection);
                ConnectionPool.closeResultSet(result);
                ConnectionPool.closePreparedStatement(statement);
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }

        return user;
    }

    /**
     * Registers a new user.
     * @param user The user object containing registration details.
     * @return The ID of the registered user.
     * @throws DAOException if there's an error during user registration.
     */
    @Override
    public int registration(User user) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        int result = -1;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(RegisterNewUser);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, UserRoles.User);
            statement.executeUpdate();
            statement = connection.prepareStatement(GetUserId);
            statement.setString(1,user.getLogin());
            rs = statement.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Incorrect login or password");
            }else
            {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            ConnectionPool.rollbackQuery(connection);
            throw new DAOException("Sql error",e);
        } finally {
            try{
                connectionPool.releaseConnection(connection);
                ConnectionPool.closeResultSet(rs);
                ConnectionPool.closePreparedStatement(statement);
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return result;
    }

}
