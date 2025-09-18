package com.acmhuang.product.controller;

import com.acmhuang.product.bean.Product;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import com.acmhuang.product.service.ProductService;

import java.net.http.HttpRequest;

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
    public Product getProduct(@PathVariable("id") Long productId,
                              HttpServletRequest request) {
        String xToken = request.getHeader("X-Token");
        System.out.println("Request here,X-Token: " + xToken);
        Product product = productService.getProduct(productId);
        return product;
    }
}