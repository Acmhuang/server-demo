package com.acmhuang.product.service;

import com.acmhuang.product.bean.Product;

/**
 * @author Acmhuang
 * @date 2025/09/17 13:32
 **/
public interface ProductService {

    Product getProduct(Long productId);
}