package com.example.demo.controller;

import com.example.demo.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderController(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        order.setStatus("PLACED");
        order.setTimestamp(LocalDateTime.now());
        kafkaTemplate.send("orders", order);
        return "Order placed: " + order.getOrderId();
    }
}
