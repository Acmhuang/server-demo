package com.acmhuang.product.controller;

import com.acmhuang.product.bean.Product;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import com.acmhuang.product.service.ProductService;

/**
 * @author Acmhuang
 * @date 2025/09/17 13:27
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable("id") Long productId) {
        System.out.println("Request here");
        Product product = productService.getProduct(productId);
        return product;
    }
}