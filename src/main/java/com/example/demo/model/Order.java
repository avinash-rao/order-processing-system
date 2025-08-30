package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "orders")
public class Order {
    @Id
    private String orderId;
    private String userId;
    private String productId;
    private int quantity;
    private double price;
    private String status;
    private LocalDateTime timestamp;

    // getters & setters
}
