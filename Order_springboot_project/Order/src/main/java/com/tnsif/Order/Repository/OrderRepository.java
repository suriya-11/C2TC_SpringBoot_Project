package com.tnsif.Order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.Order.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
