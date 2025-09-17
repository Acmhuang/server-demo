package com.acmhuang.product.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Acmhuang
 * @date 2025/09/17 13:29
 **/
@Data
public class Product {
    private Long id;
    private BigDecimal price;
    private String productName;
    private Integer num;
}