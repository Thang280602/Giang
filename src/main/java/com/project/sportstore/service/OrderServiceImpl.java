package com.project.sportstore.service;

import com.project.sportstore.model.Order;
import com.project.sportstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thang
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        // TODO Auto-generated method stub
        return this.orderRepository.findAll();
    }

    @Override
    public Boolean create(Order Order) {
        try {
            this.orderRepository.save(Order);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public Order findById(Integer id) {
        // TODO Auto-generated method stub
        return this.orderRepository.findById(id).get();
    }
}
