package com.example.demo1.logic.impl;

import com.example.demo1.bean.*;
import com.example.demo1.exception.CommandException;
import com.example.demo1.exception.DAOException;
import com.example.demo1.factory.ServiceFactory;
import com.example.demo1.logic.ICommand;
import com.example.demo1.service.DishService;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The AddProductIntoCart class implements ICommand to handle adding a product to the cart functionality.
 * It retrieves necessary parameters from the HttpServletRequest and adds the selected product to the cart.
 */
public class AddDishToBasket implements ICommand {

    /**
     * Executes the action to add a product to the cart based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the product to be added to the cart.
     * @return A String representing the JSP name to navigate after adding the product to the cart.
     * @throws CommandException           If an error occurs while executing the add to cart action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                If an I/O exception occurs during execution.
     * @throws DAOException               If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        DishService dishService = null;
        try {
            dishService = ServiceFactory.getInstance().getDishService();
            int dishId = Integer.parseInt(request.getParameter("dishId"));
            int userId = (int)request.getSession().getAttribute(SessionAtributes.UserId);

            dishService.addDishToBasket(userId, dishId);
            List<Dish> list = dishService.getDishesByCategoryId(Integer.parseInt(request.getParameter("category_id")));

            request.setAttribute("categoryArr", list);
            request.setAttribute("categoryId", Integer.parseInt(request.getParameter("category_id")));


        } catch (Exception ex) {
            throw new CommandException("Error occurred while adding a product to the cart.");
        }

        return JSPNameList.SINGLE_CATEGORY;
    }
}

