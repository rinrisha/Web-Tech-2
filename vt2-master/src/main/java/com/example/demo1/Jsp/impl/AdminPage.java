package com.example.demo1.Jsp.impl;

import com.example.demo1.bean.Dish;
import com.example.demo1.bean.SessionAtributes;
import com.example.demo1.bean.User;
import com.example.demo1.dao.DishDao;
import com.example.demo1.dao.UserDao;
import com.example.demo1.exception.CommandException;
import com.example.demo1.exception.ServiceException;
import com.example.demo1.factory.ServiceFactory;
import com.example.demo1.logic.JSPPAge;
import com.example.demo1.service.DishService;
import com.example.demo1.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class AdminPage implements JSPPAge {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<Integer> dishesAmount = new ArrayList<>();
        List<User>users = null;
        DishDao dishDao = null;
        UserDao userDao = null;
        String category = null;
        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
            users = userService.getAllUsers();

            DishService dishService = ServiceFactory.getInstance().getDishService();

            for (int i = 0; i < users.size(); i++) {

                dishesAmount.add(dishService.getUserDishesInBasket(users.get(i).getId()).size());
            }


            request.setAttribute("users", users);
            request.setAttribute("dishes", dishesAmount);

        } catch (ServiceException ex) {
            throw new CommandException("Error occurred while fetching products from the database.", ex);
        }
        return "JSP/admin.jsp";
    }
}
