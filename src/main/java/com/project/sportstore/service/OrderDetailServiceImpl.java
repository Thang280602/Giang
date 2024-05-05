package com.project.sportstore.service;

import com.project.sportstore.model.Order;
import com.project.sportstore.model.OrderDetail;
import com.project.sportstore.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thang
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    private OrderDetailRepository detailRepository;
    @Override
    public Boolean add(OrderDetail orderDetail) {
        try {
            this.detailRepository.save(orderDetail);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public List<OrderDetail> getByOrderId(Order order) {
        // TODO Auto-generated method
        return this.detailRepository.findByOrder(order);
    }


}
