package com.eCommerce.eCommerceApp.Services.Service;
import com.eCommerce.eCommerceApp.Models.Order;
import com.eCommerce.eCommerceApp.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    public List<Order> findAllOrders();
    public Optional<Order> findOrderById(Long orderId);

    public Order saveOrder(Order order);

    public void deleteOrder(Long orderId);

    public void deleteByUsername(String username);
}
