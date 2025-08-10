package com.tnsif.Order.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.Order.Entity.Order;
import com.tnsif.Order.Repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class OrderService {

	 @Autowired
	    private OrderRepository repo;

	    // Get all orders
	    public List<Order> listAll() {
	        return repo.findAll();
	    }

	    // Save order
	    public void save(Order order) {
	        repo.save(order);
	    }

	    // Get order by ID
	    public Order get(Integer id) {
	        return repo.findById(id).orElse(null); // safer than .get()
	    }

	    // Delete order
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }

	    // Update order
	    public void update(Order order) {
	        repo.save(order);
	    }

}
