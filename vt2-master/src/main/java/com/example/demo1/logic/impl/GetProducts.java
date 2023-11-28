package com.example.demo1.logic.impl;

import com.example.demo1.exception.CommandException;
import com.example.demo1.exception.DAOException;
import com.example.demo1.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * The GetProducts class implements ICommand to handle retrieving product information.
 * It retrieves products from the database based on a specified category or fetches all products if no category is specified.
 */
public class GetProducts implements ICommand {

    /**
     * Executes the action to retrieve products based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the requested product category.
     * @return A String representing the JSP name to navigate after retrieving the products.
     * @throws CommandException           If an error occurs while executing the get products action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                If an I/O exception occurs during execution.
     * @throws DAOException               If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
//        List<Dish> list = null;
//        DishDao productDao = null;
//        String category = null;
//        try {
//            ProductService productService = ServiceFactory.getInstance().getProductService();
//            category = request.getParameter("category");
//            if (category == null || category.isEmpty()){
//                list = productService.GetAllProduct();
//            } else {
//                list = productService.GetProductListByCat(category);
//            }
//
//            request.setAttribute("products", list);
//
//        } catch (ServiceException ex) {
//            throw new CommandException("Error occurred while fetching products from the database.", ex);
//        }
        return "main.jsp";
    }
}

