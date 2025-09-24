package mss301.fa.orderservice.service;

import mss301.fa.orderservice.dto.OrderDTO;
import mss301.fa.orderservice.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    Order createOrder(OrderDTO request);
    List<Order> getAllOrders();
    Optional<Order> getOrderById(int orderId);
    void deleteOrder(int orderId);

}
