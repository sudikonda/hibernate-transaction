package com.ssudikon.transaction.mapper;

import com.ssudikon.transaction.dto.ProductResponse;
import com.ssudikon.transaction.entity.Product;

public class ProductResponseMapper {

    public static ProductResponse map(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .category(product.getCategory())
                .discountPercentage(product.getDiscountPercentage())
                .name(product.getName())
                .price(product.getPrice())
                .priceWithDiscount(product.getPrice() * (1 - product.getDiscountPercentage()))
                .build();
    }
}
