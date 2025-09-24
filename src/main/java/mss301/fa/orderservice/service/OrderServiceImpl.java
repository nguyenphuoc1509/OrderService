package mss301.fa.orderservice.service;

import mss301.fa.orderservice.dto.AccountDTO;
import mss301.fa.orderservice.dto.OrchidDTO;
import mss301.fa.orderservice.dto.OrderDTO;
import mss301.fa.orderservice.dto.OrderDetailDTO;
import mss301.fa.orderservice.entity.Order;
import mss301.fa.orderservice.entity.OrderDetail;
import mss301.fa.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrchidService orchidClient;

    @Autowired
    private AccountService accountClient;

    @Override
    public Order createOrder(OrderDTO request) {
        AccountDTO accountDTO = accountClient.getAccount(request.getAccountID());
        Order order = new Order();
        order.setOrderDate(java.sql.Timestamp.valueOf(LocalDateTime.now()));
        order.setOrderDetails(new ArrayList<>());
        order.setAccountId(accountDTO.getAccountID());
        order.setOderStatus(request.getStatus());
        double totalAmount = 0;
        for (OrderDetailDTO detail : request.getDetails()){
            OrchidDTO orchid = orchidClient.getOrchid(detail.getOrchidId());
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrchidId(orchid.getOrchidId());
            orderDetail.setQuantity(detail.getQuantity());
            orderDetail.setPrice(orchid.getPrice());
            totalAmount += orchid.getPrice() * orderDetail.getQuantity();
            order.getOrderDetails().add(orderDetail);
        }
        order.setTotalAmount(totalAmount);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(int orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }
}
