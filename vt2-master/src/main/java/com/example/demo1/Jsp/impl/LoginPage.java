package com.example.demo1.Jsp.impl;

import com.example.demo1.exception.CommandException;
import com.example.demo1.logic.JSPPAge;
import jakarta.servlet.http.HttpServletRequest;

public class LoginPage implements JSPPAge {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return "JSP/login.jsp";
    }
}
