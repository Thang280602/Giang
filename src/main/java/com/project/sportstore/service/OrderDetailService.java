package com.project.sportstore.service;

import com.project.sportstore.model.Order;
import com.project.sportstore.model.OrderDetail;

import java.util.List;

/**
 * @author thang
 */
public interface OrderDetailService {
    Boolean add(OrderDetail orderDetail);
    List<OrderDetail> getByOrderId(Order order);
}
