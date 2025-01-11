package com.ssudikon.transaction.service;

import com.ssudikon.transaction.entity.Product;
import com.ssudikon.transaction.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

//    public List<ProductResponse> getAllProducts() {
//        return productRepository.findAll()
//                .stream()
//                .map(ProductResponseMapper::map)
//                .toList();
//    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
