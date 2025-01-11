package com.ssudikon.transaction.handler;

import com.ssudikon.transaction.entity.Product;
import com.ssudikon.transaction.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryHandler {

    private final InventoryRepository inventoryRepository;

    public InventoryHandler(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Product updateProduct(Product product) {
        // simulate database error
        if (Math.random() < 0.5) {
            throw new RuntimeException("Database error");
        }

        return inventoryRepository.save(product);
    }

    public Product getProduct(Long id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
