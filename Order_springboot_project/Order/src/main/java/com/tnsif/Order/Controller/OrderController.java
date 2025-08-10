package com.tnsif.Order.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tnsif.Order.Entity.Order;
import com.tnsif.Order.Service.OrderService;

import jakarta.persistence.NoResultException;

@RestController

public class OrderController {
	@Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> list() {
        return orderService.listAll();
    }

    @PostMapping("/orders")
    public void add(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> get(@PathVariable Integer id) {
        try {
            Order existingOrder = orderService.get(id);
            return new ResponseEntity<>(existingOrder, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.delete(id);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> update(@PathVariable Integer id, @RequestBody Order updatedOrder) {
        try {
            Order existingOrder = orderService.get(id);
            existingOrder.setOrderName(updatedOrder.getOrderName());
            existingOrder.setOrderAmount(updatedOrder.getOrderAmount());
            existingOrder.setCustomerName(updatedOrder.getCustomerName());
            orderService.update(existingOrder);
            return new ResponseEntity<>(existingOrder, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
