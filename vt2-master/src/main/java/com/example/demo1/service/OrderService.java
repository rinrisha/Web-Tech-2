package com.example.demo1.service;

import com.example.demo1.exception.ServiceException;

import java.util.List;

public interface OrderService {
    /**
     * Creates an order with the given address and cart items.
     * @param address The address for the order.
     * @param cart The list of cart items to be included in the order.
     * @throws ServiceException if there's an error during order creation.
     */
//    void createOrder(String address, List<CartItem> cart) throws ServiceException;
}
