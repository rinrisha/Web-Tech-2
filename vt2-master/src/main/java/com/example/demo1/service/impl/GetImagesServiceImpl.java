package com.example.demo1.service.impl;

import com.example.demo1.dao.impl.SQLImagesDAO;
import com.example.demo1.exception.DAOException;

import java.util.List;

public class GetImagesServiceImpl {
    public List<String> getImages() throws DAOException {
        SQLImagesDAO imagesdao = new SQLImagesDAO();
        List<String> imgs = imagesdao.getImages();
        return imgs;
    }
}
