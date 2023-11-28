package com.example.demo1.dao;

import com.example.demo1.bean.Dish;
import com.example.demo1.exception.DAOException;

import java.io.InputStream;
import java.util.List;

/**
 * Interface handling product-related database operations.
 */
public interface DishDao {

    /**
     * Retrieves a list of products by category.
     * @param categoryId The id of dish to retrieve.
     * @return List of products belonging to the specified category.
     * @throws DAOException if there's an error while fetching products.
     */
    List<Dish> GetDishesListByCategoryId(int categoryId) throws DAOException;

    void DecrementDishAmountInBasket(int userId, int dishId) throws DAOException;
    void IncrementDishAmountInBasket(int userId, int dishId) throws DAOException;

    /**
     * Adds a new product to the database.
     * @param userId the id of user.
     * @param dishId thi id of dish.
     * @throws DAOException if there's an error while adding the product.
     */
    boolean AddDishToBasket(int userId, int dishId) throws DAOException;

    /**
     * Recievs dish by its id.
     * @param id The id of the dish.
     * @throws DAOException if there's an error while adding the product.
     */
    Dish GetDishById(int id) throws DAOException;
    /**
     * Recievs dishes by user id.
     * @param id The id of the user.
     * @throws DAOException if there's an error while adding the product.
     */
    List<Dish> GetDishesByUserId(int id) throws DAOException;
}
