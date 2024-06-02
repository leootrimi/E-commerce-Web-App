package com.eCommerce.eCommerceApp.Controllers;

import com.eCommerce.eCommerceApp.Exceptions.Order.OrderCreationException;
import com.eCommerce.eCommerceApp.Exceptions.Order.OrderDeletionException;
import com.eCommerce.eCommerceApp.Exceptions.Order.OrderNotFoundException;
import com.eCommerce.eCommerceApp.Models.Order;
import com.eCommerce.eCommerceApp.Services.Service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@Tag(name = "Orders Functions")

public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Optional<Order> order = orderService.findOrderById(orderId);
        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        } else {
            throw new OrderNotFoundException("Order with id " + orderId + " not found");
        }
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        try {
            return orderService.saveOrder(order);
        } catch (Exception e) {
            throw new OrderCreationException("Failed to create order");
        }
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        try {
            orderService.deleteOrder(orderId);
        } catch (Exception e) {
            throw new OrderDeletionException("Failed to delete order with id " + orderId);
        }
    }
}

