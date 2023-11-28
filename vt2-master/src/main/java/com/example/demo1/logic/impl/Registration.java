package com.example.demo1.logic.impl;

import com.example.demo1.bean.JSPNameList;
import com.example.demo1.bean.SessionAtributes;
import com.example.demo1.bean.User;
import com.example.demo1.exception.CommandException;
import com.example.demo1.exception.ServiceException;
import com.example.demo1.factory.ServiceFactory;
import com.example.demo1.logic.ICommand;
import com.example.demo1.service.UserService;
import jakarta.servlet.http.HttpServletRequest;


/**
 * The Register class implements ICommand to handle user registration functionality.
 * It interacts with the UserDao to register a new user based on provided information.
 */
public class Registration implements ICommand {

    /**
     * Executes the action to register a new user based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information about the user registration.
     * @return A String representing the JSP name to navigate after registering the user.
     * @throws CommandException           If an error occurs while executing the user registration action.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = new User();
        UserService userService = null;
        try {
            userService = ServiceFactory.getInstance().getUserService();

            user.setLogin(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));
            int userId = userService.registration(user);
            request.setAttribute("SomeMessage", "Successful registration");
            request.getSession().setAttribute(SessionAtributes.Authorized, true);
            request.getSession().setAttribute(SessionAtributes.UserId, userId);
        } catch (ServiceException ex) {
            throw new CommandException("Error occurred during user registration.", ex);
        }
        return JSPNameList.MAIN_PAGE;
    }
}

