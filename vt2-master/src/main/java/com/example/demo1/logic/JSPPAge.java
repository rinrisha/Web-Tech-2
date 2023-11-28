package com.example.demo1.logic;

import com.example.demo1.exception.CommandException;
import com.example.demo1.exception.DAOException;
import jakarta.servlet.http.HttpServletRequest;

public interface JSPPAge {


    String execute(HttpServletRequest request) throws CommandException, DAOException;
}

