package com.example.demo1.service.impl;

import com.example.demo1.bean.Dish;
import com.example.demo1.dao.DishDao;
import com.example.demo1.exception.DAOException;
import com.example.demo1.exception.ServiceException;
import com.example.demo1.factory.DAOFactory;
import com.example.demo1.service.DishService;

import java.util.List;

public class DishServiceImpl implements DishService {
    @Override
    public List<Dish> getUserDishesInBasket(int userId) throws ServiceException{
        List<Dish> list = null;
        try {

            DishDao productDao = DAOFactory.getFactory().getProductDao();
            list = productDao.GetDishesByUserId(userId);


        }catch (DAOException ex){
            throw  new ServiceException(ex);
        }

        return list;

    }

    @Override
    public List<Dish> getDishesByCategoryId(int categoryId) throws ServiceException {
        List<Dish> list = null;
        try {

            DishDao productDao = DAOFactory.getFactory().getProductDao();
            list = productDao.GetDishesListByCategoryId(categoryId);


        }catch (DAOException ex){
            throw  new ServiceException(ex);
        }

        return list;
    }

    @Override
    public void incrementDishAmount(int userId, int dishId) throws ServiceException{
        try {

            DishDao dishDao = DAOFactory.getFactory().getProductDao();
            dishDao.IncrementDishAmountInBasket(userId, dishId);


        }catch (DAOException ex){
            throw  new ServiceException(ex);
        }
    }

    @Override
    public void decrementDishAmount(int userId, int dishId)throws ServiceException {
        try {

            DishDao dishDao = DAOFactory.getFactory().getProductDao();
            dishDao.DecrementDishAmountInBasket(userId, dishId);


        }catch (DAOException ex){
            throw  new ServiceException(ex);
        }
    }

    @Override
    public void addDishToBasket(int userId, int dishId) throws ServiceException {
        try {

            DishDao productDao = DAOFactory.getFactory().getProductDao();
            productDao.AddDishToBasket(userId, dishId);


        }catch (DAOException ex){
            throw  new ServiceException(ex);
        }
    }
}
