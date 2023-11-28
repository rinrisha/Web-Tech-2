package com.example.demo1.dao.impl;

import com.example.demo1.exception.DAOException;
import com.example.demo1.factory.ConnectionPoolFactory;
import com.example.demo1.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLImagesDAO {
    //private static final String getAllImages = "SELECT * FROM rubbish";
    private static final String getAllImages = "SELECT * FROM rubbish";
    public List<String> getImages() throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        List<String> imgs = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(getAllImages);
            rs = statement.executeQuery();
            while (rs.next()) {
                String img = rs.getString(2);
                imgs.add(img);

            }
        } catch (SQLException e) {
            ConnectionPool.rollbackQuery(connection);
            throw new DAOException("Sql error", e);
        } finally {
            try {
                connectionPool.releaseConnection(connection);
                ConnectionPool.closeResultSet(rs);
                ConnectionPool.closePreparedStatement(statement);
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return imgs;
    }
}
