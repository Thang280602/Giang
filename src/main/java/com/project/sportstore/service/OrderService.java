package com.project.sportstore.service;

import com.project.sportstore.model.Order;

import java.util.List;

/**
 * @author thang
 */
public interface OrderService {
    List<Order> getAll();
    Boolean create(Order Order);
    Order findById(Integer id);
}
