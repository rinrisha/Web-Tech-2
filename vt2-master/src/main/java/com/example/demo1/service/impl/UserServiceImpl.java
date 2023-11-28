package com.example.demo1.service.impl;

import com.example.demo1.bean.User;
import com.example.demo1.dao.UserDao;
import com.example.demo1.exception.DAOException;
import com.example.demo1.exception.ServiceException;
import com.example.demo1.factory.DAOFactory;
import com.example.demo1.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUsers() throws ServiceException {
        List<User> users = null;
        UserDao userDao = null;
        try {
            userDao = DAOFactory.getFactory().getUserDao();

            users = userDao.GetAllUsers();

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return users;
    }

    @Override
    public User signIn(String login, String password) throws ServiceException {
        User user = null;
        UserDao userDao = null;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            if (login == null || password == null) {
                throw new ServiceException("Incorrect password or login");
            }
            user = userDao.signIn(login, password);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return user;
    }

    @Override
    public int registration(User user) throws ServiceException {
        UserDao userDao = null;
        int id = -1;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            if (user.getPassword() == null || user.getLogin() == null) {
                throw new ServiceException("Incorrect password or login");
            }
            id = userDao.registration(user);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return id;
    }
}
