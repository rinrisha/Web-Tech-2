package com.example.demo1.dao.impl;

import com.example.demo1.bean.Dish;
import com.example.demo1.dao.DishDao;
import com.example.demo1.exception.DAOException;
import com.example.demo1.factory.ConnectionPoolFactory;
import com.example.demo1.pool.ConnectionPool;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ProductDao handling product-related database operations.
 */
public class SQLDishDAO implements DishDao {

    /**
     * SQL statement to get products by category name from the database.
     */
    private static final String GetDishesByCategoryId = "SELECT dish_id FROM categories WHERE category_id = ?";
    private static final String GetDishFromBasket = "SELECT dish_id, dish_amount FROM basket WHERE user_id = ? AND dish_id = ?";
    private static final String SetAmountInBasket = "UPDATE basket SET dish_amount = ? WHERE user_id = ? AND dish_id = ?";

    private static final String DeleteDishFromBasket = "DELETE FROM basket WHERE user_id = ? AND dish_id = ?";
    /**
     * SQL statement to get a product by its ID from the database.
     */
    private static final String GetDishById = "SELECT dish_id, name, price, description, img FROM dishes WHERE dish_id = ?";
    /**
     * SQL statement to get a product by its ID from the database.
     */
    private static final String GetDishByUsrId = "SELECT dish_id, dish_amount FROM basket WHERE user_id = ?";
    /**
     * SQL statement to add a new product to the database.
     */
    private static final String AddToBasket = "INSERT INTO basket (row_id, user_id, dish_id, dish_amount) VALUES (null, ?, ?, 1)";

    @Override
    public void DecrementDishAmountInBasket(int userId, int dishId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        int categoryNumber;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(GetDishFromBasket);
            statement.setInt(1, userId);
            statement.setInt(2, dishId);
            rs = statement.executeQuery();
            if (rs.next()) {
                int amount = rs.getInt(2);
                amount--;
                if (amount == 0) {
                    statement = connection.prepareStatement(DeleteDishFromBasket);
                    statement.setInt(1, userId);
                    statement.setInt(2, dishId);
                    int n = statement.executeUpdate();
                    if (n == 0) {
                        throw new DAOException("Dish decrement exception");
                    }
                } else {
                    statement = connection.prepareStatement(SetAmountInBasket);
                    statement.setInt(1, amount);
                    statement.setInt(2, userId);
                    statement.setInt(3, dishId);
                    int n = statement.executeUpdate();
                    if (n == 0) {
                        throw new DAOException("Dish decrement exception");
                    }
                }

            } else {
                throw new DAOException("Dish decrement exception");
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
    }

    @Override
    public void IncrementDishAmountInBasket(int userId, int dishId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        int categoryNumber;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(GetDishFromBasket);
            statement.setInt(1, userId);
            statement.setInt(2, dishId);
            rs = statement.executeQuery();
            if (rs.next()) {
                int amount = rs.getInt(2);
                amount++;
                statement = connection.prepareStatement(SetAmountInBasket);
                statement.setInt(1, amount);
                statement.setInt(2, userId);
                statement.setInt(3, dishId);
                int n = statement.executeUpdate();
                if (n == 0) {
                    throw new DAOException("Dish increment exception");
                }

            } else {
                throw new DAOException("Dish increment exception");
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
    }

    /**
     * Retrieves a list of products by category name from the database.
     *
     * @param categoryId The category id.
     * @return The list of products in the specified category.
     * @throws DAOException if there's an error retrieving the products.
     */
    @Override
    public List<Dish> GetDishesListByCategoryId(int categoryId) throws DAOException {
        List<Dish> list = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(GetDishesByCategoryId);
            statement.setInt(1, categoryId);
            rs = statement.executeQuery();
            while (rs.next()) {
                Dish tempdish = GetDishById(rs.getInt(1));
                list.add(tempdish);
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
        return list;
    }

    /**
     * Adds a new product to the database.
     *
     * @param dishId id of dish.
     * @throws DAOException if there's an error adding the product.
     */
    @Override
    public boolean AddDishToBasket(int userId, int dishId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        int categoryNumber;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(GetDishFromBasket);
            statement.setInt(1, userId);
            statement.setInt(2, dishId);
            rs = statement.executeQuery();
            if (rs.next()) {
                int amount = rs.getInt(1);
                amount++;
                statement = connection.prepareStatement(SetAmountInBasket);
                statement.setInt(1, amount);
                statement.setInt(2, userId);
                statement.setInt(3, dishId);
                int n = statement.executeUpdate();
                if (n == 0) {
                    throw new DAOException("Product add exception");
                }
            } else {
                statement = connection.prepareStatement(AddToBasket);
                statement.setInt(1, userId);
                statement.setInt(2, dishId);
                int n = statement.executeUpdate();
                if (n == 0) {
                    throw new DAOException("Product add exception");
                }
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
        return true;
    }

    @Override
    public Dish GetDishById(int id) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        Dish dish = null;
        try {
            con = connectionPool.getConnection();
            ps = con.prepareStatement(GetDishById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                dish = new Dish(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5));
//                dish = new Dish(1, "2", 3, "4", "5");
            }
        } catch (SQLException e) {
            ConnectionPool.rollbackQuery(con);
            throw new DAOException("Sql error", e);
        } finally {
            try {
                connectionPool.releaseConnection(con);
                ConnectionPool.closeResultSet(rs);
                ConnectionPool.closePreparedStatement(ps);
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return dish;
    }

    /**
     * Retrieves a product by user ID from the database.
     *
     * @param userid The ID of the user.
     * @return The dishes list that's in user's basket.
     * @throws DAOException if there's an error retrieving the product.
     */
    @Override
    public List<Dish> GetDishesByUserId(int userid) throws DAOException {
        List<Dish> list = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(GetDishByUsrId);
            statement.setInt(1, userid);
            rs = statement.executeQuery();
            while (rs.next()) {
                int amount = rs.getInt(2);
                Dish tempdish = GetDishById(rs.getInt(1));
                tempdish.setAmount(amount);
                list.add(tempdish);

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
        return list;
    }
}
