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

public class SingleCotegoryPage implements JSPPAge {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<Dish> list = null;
        DishDao dishDao = null;
        String category = null;
        try {
            DishService dishService = ServiceFactory.getInstance().getDishService();
            list = dishService.getDishesByCategoryId(Integer.parseInt(request.getParameter("category_id")));


            request.setAttribute("categoryArr", list);
            request.setAttribute("categoryId", Integer.parseInt(request.getParameter("category_id")));

        } catch (ServiceException ex) {
            throw new CommandException("Error occurred while fetching products from the database.", ex);
        }
        return "JSP/single-category.jsp";
    }
}
