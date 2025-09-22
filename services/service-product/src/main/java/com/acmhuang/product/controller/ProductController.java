package com.acmhuang.product.controller;

import com.acmhuang.product.bean.Product;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import com.acmhuang.product.service.ProductService;

import java.net.http.HttpRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author Acmhuang
 * @date 2025/09/17 13:27
 **/
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable("id") Long productId,
                              HttpServletRequest request) {
        String xToken = request.getHeader("X-Token");
        System.out.println("Request here,X-Token: " + xToken);
        Product product = productService.getProduct(productId);
//        模拟请求的异常情况
//        int a = 1/0;
//        try{
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e){
//            throw new RuntimeException(e);
//        }
        return product;
    }
}