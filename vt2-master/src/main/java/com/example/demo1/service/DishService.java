package com.example.demo1.service;

import com.example.demo1.bean.Dish;
import com.example.demo1.exception.ServiceException;

import java.util.List;

public interface DishService {
    public List<Dish> getUserDishesInBasket(int userId) throws ServiceException;

    public List<Dish> getDishesByCategoryId(int id) throws ServiceException;

    public void decrementDishAmount(int userId, int dishId) throws ServiceException;

    public void incrementDishAmount(int userId, int dishId) throws ServiceException;

    public void addDishToBasket(int userId, int dishId) throws ServiceException;

}
