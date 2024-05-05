package com.project.sportstore.repository;

import com.project.sportstore.model.Order;
import com.project.sportstore.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author thang
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findByOrder(Order order);
}

