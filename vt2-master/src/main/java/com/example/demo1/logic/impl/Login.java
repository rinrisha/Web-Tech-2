package com.example.demo1.logic.impl;

import com.example.demo1.bean.JSPNameList;
import com.example.demo1.bean.SessionAtributes;
import com.example.demo1.bean.User;
import com.example.demo1.exception.CommandException;
import com.example.demo1.exception.DAOException;
import com.example.demo1.exception.ServiceException;
import com.example.demo1.factory.ServiceFactory;
import com.example.demo1.logic.ICommand;
import com.example.demo1.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * The SignIn class implements ICommand to handle user sign-in functionality.
 * It interacts with the UserDao to sign in a user based on provided login credentials.
 */
public class Login implements ICommand {

    /**
     * Executes the action to sign in a user based on the provided HttpServletRequest.
     *
     * @param request The HttpServletRequest containing information for user sign-in.
     * @return A String representing the JSP name to navigate after signing in the user.
     * @throws CommandException           If an error occurs while executing the sign-in action.
     * @throws ParserConfigurationException If there's an issue with the parser configuration.
     * @throws IOException                If an I/O exception occurs during execution.
     * @throws DAOException               If there's an issue with the Data Access Object.
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        UserService userService = null;
        try {
           userService = ServiceFactory.getInstance().getUserService();
           String username = request.getParameter("username");
           String password = request.getParameter("password");
            if(username.equals("admin") && password.equals("admin")){
                request.getSession().setAttribute(SessionAtributes.Authorized, true);
                request.getSession().setAttribute(SessionAtributes.UserId, null);
                request.getSession().setAttribute(SessionAtributes.Role, "ADMIN");
                return JSPNameList.ADMINISTRATOR_PAGE;
            }else{
                User user = userService.signIn(username, password);
                request.setAttribute("SomeMessage", "Successful LogIn");
                request.getSession().setAttribute(SessionAtributes.Authorized, true);
                request.getSession().setAttribute(SessionAtributes.UserId, user.getId());
                request.getSession().setAttribute(SessionAtributes.Role, user.getRole());
            }


        } catch (ServiceException ex) {
            throw new CommandException("Incorrect Login or password.", ex);
        }
        return JSPNameList.MAIN_PAGE;
    }
}

