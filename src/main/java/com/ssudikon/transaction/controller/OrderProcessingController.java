package com.ssudikon.transaction.controller;

import com.ssudikon.transaction.entity.Order;
import com.ssudikon.transaction.service.OrderProcessingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderProcessingController {

    private final OrderProcessingService orderProcessingService;

    public OrderProcessingController(OrderProcessingService orderProcessingService) {
        this.orderProcessingService = orderProcessingService;
    }

    @PostMapping("/process-order")
    public ResponseEntity<Order> processOrder(Order order) {
        Order processedOrder = orderProcessingService.processOrder(order);
        return ResponseEntity.ok(processedOrder);
    }
}
