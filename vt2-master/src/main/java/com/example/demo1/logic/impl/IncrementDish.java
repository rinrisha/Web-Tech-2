package com.example.demo1.logic.impl;

import com.example.demo1.bean.Dish;
import com.example.demo1.bean.JSPNameList;
import com.example.demo1.bean.SessionAtributes;
import com.example.demo1.exception.CommandException;
import com.example.demo1.exception.DAOException;
import com.example.demo1.factory.ServiceFactory;
import com.example.demo1.logic.ICommand;
import com.example.demo1.service.DishService;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class IncrementDish implements ICommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        DishService dishService = null;
        try {
            dishService = ServiceFactory.getInstance().getDishService();
            int dishId = Integer.parseInt(request.getParameter("dishId"));
            int userId = (int)request.getSession().getAttribute(SessionAtributes.UserId);

            dishService.incrementDishAmount(userId, dishId);

            List<Dish> list = dishService.getUserDishesInBasket((int)request.getSession().getAttribute(SessionAtributes.UserId));
            request.setAttribute("basketArr", list);
            request.setAttribute("basketArrSize", list.size());


        } catch (Exception ex) {
            throw new CommandException("Error occurred while adding a product to the cart.");
        }

        return JSPNameList.BASKET_PAGE;
    }
}
