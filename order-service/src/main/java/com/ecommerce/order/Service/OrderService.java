package com.ecommerce.order.Service;

import com.ecommerce.order.Entity.Order;
import com.ecommerce.order.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final KafkaProducerService producer;
    private final OrderRepository orderRepository;

    public Order placeOrder(String userEmail, List<String> items, double totalAmount) {
        Order order = new Order();
        order.setUserEmail(userEmail);
        order.setItems(items);
        order.setTotalAmount(totalAmount);
        order.setStatus("PENDING");


        Order saved =  orderRepository.save(order);

        producer.sendOrderEvent("Order Created: " + saved.getId());

        return saved;
    }
}
