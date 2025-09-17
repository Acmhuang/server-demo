package com.acmhuang.order.bean;

import com.acmhuang.product.bean.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Acmhuang
 * @date 2025/09/17 14:10
 **/
@Data
public class Order {
    private Long id;
    private BigDecimal totalPrice;
    private Long userId;
    private String nickName;
    private String address;
    private List<Product> productList;
}