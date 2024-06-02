package com.eCommerce.eCommerceApp.Service;
import com.eCommerce.eCommerceApp.Models.Order;
import com.eCommerce.eCommerceApp.Repository.OrderRepository;
import com.eCommerce.eCommerceApp.Services.ServiceImpl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void saveOrderTest() {
        Order order = new Order();
        order.setFullName("John Doe");
        order.setUsername("johndoe");

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order savedOrder = orderService.saveOrder(order);
        assertThat(savedOrder).isNotNull();
    }

    @Test
    public void findAllOrdersTest() {
        List<Order> orderList = new ArrayList<>();

        when(orderRepository.findAll()).thenReturn(orderList);

        List<Order> result = orderService.findAllOrders();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(orderList.size());
    }

    @Test
    public void findOrderByIdTest() {
        Long orderId = 1L;
        Order order = new Order();

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        Optional<Order> result = orderService.findOrderById(orderId);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(order);
    }


    @Test
    public void deleteOrderTest() {
        Long orderId = 1L;

        orderService.deleteOrder(orderId);

        verify(orderRepository, times(1)).deleteById(orderId);
    }

    @Test
    public void deleteByUsernameTest() {
        String username = "testUser";

        orderService.deleteByUsername(username);

        verify(orderRepository, times(1)).deleteByUsername(username);
    }

}
