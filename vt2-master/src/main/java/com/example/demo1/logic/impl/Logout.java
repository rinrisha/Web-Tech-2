package com.example.demo1.logic.impl;

import com.example.demo1.bean.JSPNameList;
import com.example.demo1.exception.CommandException;
import com.example.demo1.exception.DAOException;
import com.example.demo1.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * The LogOut class implements ICommand to handle user logout functionality.
 * It invalidates the current session and prepares to redirect to the main page after logging out.
 */
public class Logout implements ICommand {

    /**
     * Executes the action to log out the user based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the current user session.
     * @return A String representing the JSP name to navigate after logging out.
     * @throws CommandException           If an error occurs while executing the logout action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                If an I/O exception occurs during execution.
     * @throws DAOException               If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
//        try {
//            ProductDao productDao = DAOFactory.getFactory().getProductDao();
//            List<Product> products = productDao.GetAllProduct();
            request.getSession().invalidate();
//            request.setAttribute("products", products);

//        } catch (DAOException ex) {
//            throw new CommandException("Error occurred during logout process.", ex);
//        }
        return JSPNameList.MAIN_PAGE;
    }
}


