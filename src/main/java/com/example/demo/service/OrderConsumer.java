package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final OrderRepository repository;

    public OrderConsumer(OrderRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "orders", groupId = "order-group")
    public void consume(Order order) {
        repository.save(order);
        System.out.println("Order saved: " + order.getOrderId());
    }
}
