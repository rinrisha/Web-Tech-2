package com.example.demo1.Jsp.impl;

import com.example.demo1.bean.Dish;
import com.example.demo1.bean.SessionAtributes;
import com.example.demo1.dao.DishDao;
import com.example.demo1.exception.CommandException;
import com.example.demo1.exception.ServiceException;
import com.example.demo1.factory.ServiceFactory;
import com.example.demo1.logic.JSPPAge;
import com.example.demo1.service.DishService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class BasketPage implements JSPPAge {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<Dish> list = null;
        DishDao dishDao = null;
        String category = null;
        try {
            DishService dishService = ServiceFactory.getInstance().getDishService();
            list = dishService.getUserDishesInBasket((int)request.getSession().getAttribute(SessionAtributes.UserId));

            request.setAttribute("basketArr", list);
            request.setAttribute("basketArrSize", list.size());

        } catch (ServiceException ex) {
            throw new CommandException("Error occurred while fetching products from the database.", ex);
        }
        return "JSP/basket.jsp";
    }
}
