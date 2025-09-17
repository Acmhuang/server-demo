package com.acmhuang.order.controller;

import com.acmhuang.order.bean.Order;
import com.acmhuang.order.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author Acmhuang
 * @date 2025/09/17 14:13
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/create")
    public Order getOrder(@RequestParam("productId") Long productId,@RequestParam("userId") Long userId) {
        return orderService.craeteOrder(productId, userId);
    }
}