package com.ssudikon.transaction.repository;

import com.ssudikon.transaction.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
