package com.project.sportstore.repository;

import com.project.sportstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author thang
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}

