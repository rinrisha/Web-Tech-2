package com.example.demo1.service;

import com.example.demo1.bean.User;
import com.example.demo1.exception.DAOException;
import com.example.demo1.exception.ServiceException;

import java.util.List;

public interface UserService {
    /**
     * Validates user sign-in credentials.
     * @param login The user's login username.
     * @param password The user's password.
     * @return User object if the login is successful.
     * @throws DAOException if there's an error during sign-in.
     */
    User signIn(String login, String password) throws ServiceException;

    /**
     * Registers a new user.
     * @param user The user object containing registration details.
     * @return ID of the registered user.
     * @throws DAOException if there's an error during registration.
     */
    int registration(User user) throws ServiceException;

    List<User> getAllUsers() throws  ServiceException;

}
