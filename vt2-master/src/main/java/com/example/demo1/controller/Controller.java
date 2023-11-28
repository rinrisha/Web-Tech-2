package com.example.demo1.controller;


import com.example.demo1.Jsp.impl.AdminPage;
import com.example.demo1.bean.JSPNameList;
import com.example.demo1.exception.CommandException;
import com.example.demo1.factory.ConnectionPoolFactory;
import com.example.demo1.logic.CommandHelper;
import com.example.demo1.logic.ICommand;
import com.example.demo1.logic.JSPHelper;
import com.example.demo1.logic.JSPPAge;
import com.example.demo1.pool.ConnectionPool;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@MultipartConfig
public class Controller extends HttpServlet {

    public Controller() {
        super();
    }

    @Override
    public void init() throws ServletException {
        try {

            ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
            connectionPool.CreateConnections();

        } catch (ClassNotFoundException e) {

            System.out.println("ERROR: " + e.getMessage());
        } catch (SQLException ex) {

            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        JSPPAge pageContent = JSPHelper.getJspHelper().getPage(requestURI);
        String page;
        String lang = req.getParameter("lang");
        if(lang != null){
            req.setAttribute("language", lang);
            req.getSession().setAttribute("language", lang);
        }
        if (req.getSession().getAttribute("language") == null) {
            req.getSession().setAttribute("language", "ru");
        }

        try {
            page = pageContent.execute(req);
        } catch (CommandException e) {
            System.out.println("ERROR: Page exception in Controller " + e.getMessage());

            page = JSPNameList.ERROR_PAGE;
            req.setAttribute("error", e.getMessage());

        } catch (Exception e) {
            page = JSPNameList.ERROR_PAGE;
            System.out.println("ERROR: Page exception in Controller " + e.getMessage());

            req.setAttribute("error", e.getMessage());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(page);

        if (dispatcher != null) {
            dispatcher.forward(req, resp);
        } else {
            //LOG
            System.out.println("RequestDispatcher is NULL");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("command");
        ICommand command = CommandHelper.getCommandHelper().getCommand(commandName);
        String result = null;
        try {
            result = command.execute(req);
            if(commandName.equals("LOG_IN") && result.equals(JSPNameList.ADMINISTRATOR_PAGE)){
                AdminPage adminPage = new AdminPage();
                adminPage.execute(req);
            }
        } catch (CommandException ex) {
            result = JSPNameList.ERROR_PAGE;
            req.setAttribute("error", ex.getMessage());
            System.out.println("ERROR: Failed to execute command " + ex.getMessage());

        } catch (Exception ex) {
            result = JSPNameList.ERROR_PAGE;
            req.setAttribute("error", ex.getMessage());
            System.out.println("ERROR: Page exception in Cotroller " + ex.getMessage());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(result);
        if (dispatcher != null) {
            dispatcher.forward(req, resp);
        }
    }
}
