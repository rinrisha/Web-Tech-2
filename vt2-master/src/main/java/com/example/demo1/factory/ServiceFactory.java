package com.example.demo1.factory;

import com.example.demo1.service.DishService;
import com.example.demo1.service.OrderService;
import com.example.demo1.service.UserService;
import com.example.demo1.service.impl.DishServiceImpl;
import com.example.demo1.service.impl.OrderServiceImpl;
import com.example.demo1.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();
//    private final ProductService productService = new ProductServiceImpl();
    private final DishService dishService = new DishServiceImpl();
    private ServiceFactory(){}
    public static ServiceFactory getInstance(){
        return instance;
    }

//    public ProductService getProductService(){
//        return productService;
//    }
    public UserService getUserService(){
        return userService;
    }
    public DishService getDishService(){
        return dishService;
    }
}
