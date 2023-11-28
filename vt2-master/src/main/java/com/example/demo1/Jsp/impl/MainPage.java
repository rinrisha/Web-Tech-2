package com.example.demo1.Jsp.impl;

import com.example.demo1.exception.CommandException;
import com.example.demo1.exception.DAOException;
import com.example.demo1.logic.JSPPAge;
import com.example.demo1.service.impl.GetImagesServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class MainPage implements JSPPAge {

    @Override
    public String execute(HttpServletRequest request) throws CommandException, DAOException {
        GetImagesServiceImpl imgService = new GetImagesServiceImpl();
        List<String> imgs = imgService.getImages();
        request.getSession().setAttribute("jumbotron", imgs.get(0));
        request.getSession().setAttribute("breakfast", imgs.get(1));
        request.getSession().setAttribute("streetfood", imgs.get(2));
        request.getSession().setAttribute("soup", imgs.get(3));
        request.getSession().setAttribute("deserts", imgs.get(4));
        return "main.jsp";
    }
}
