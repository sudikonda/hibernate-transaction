package com.ssudikon.transaction.handler;

import com.ssudikon.transaction.entity.Order;
import com.ssudikon.transaction.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderHandler {

    private final OrderRepository orderRepository;

    public OrderHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        // simulate database error
        if (Math.random() < 0.5) {
            throw new RuntimeException("Database error");
        }
        return orderRepository.save(order);
    }
}
