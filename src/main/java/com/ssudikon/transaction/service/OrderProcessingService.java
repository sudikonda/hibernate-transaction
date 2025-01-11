package com.ssudikon.transaction.service;

import com.ssudikon.transaction.entity.Order;
import com.ssudikon.transaction.entity.Product;
import com.ssudikon.transaction.handler.InventoryHandler;
import com.ssudikon.transaction.handler.OrderHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderProcessingService {

    private final InventoryHandler inventoryHandler;
    private final OrderHandler orderHandler;

    public OrderProcessingService(InventoryHandler inventoryHandler, OrderHandler orderHandler) {
        this.inventoryHandler = inventoryHandler;
        this.orderHandler = orderHandler;
    }

    public Order processOrder(Order order) {
        log.info("Processing order: {}", order);
        Long productId = order.getProductId();

        Product product = inventoryHandler.getProduct(productId);
        if (product.getStockQuantity() < order.getQuantity()) {
            log.error("Not enough stock for product: {}", productId);
            throw new RuntimeException("Not enough stock for product: " + productId);
        }

        order.setTotalPrice(product.getPriceWithDiscount() * order.getQuantity());
        log.info("Updated order total price: {}", order);

        product.setStockQuantity(product.getStockQuantity() - order.getQuantity());
        inventoryHandler.updateProduct(product);
        log.info("Updated product stock quantity: {}", product);

        return orderHandler.saveOrder(order);
    }

}
