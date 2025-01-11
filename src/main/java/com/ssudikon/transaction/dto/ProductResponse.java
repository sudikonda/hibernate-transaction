package com.ssudikon.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String category;
    private double discountPercentage;
    private String name;
    private double price;
    private double priceWithDiscount;
}
