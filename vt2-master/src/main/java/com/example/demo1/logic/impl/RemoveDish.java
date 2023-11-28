package com.example.demo1.logic.impl;

import com.example.demo1.exception.CommandException;
import com.example.demo1.exception.DAOException;
import com.example.demo1.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RemoveDish implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, ParserConfigurationException, IOException, DAOException {
        return null;
    }
}
