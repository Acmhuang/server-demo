package com.acmhuang.order.controller;

import com.acmhuang.order.bean.Order;
import com.acmhuang.order.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author Acmhuang
 * @date 2025/09/17 14:13
 **/
//激活配置文件刷新
@RefreshScope
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Value("${order:timeout}")
    private String orderTimeout;

    @Value("${order:auto-confirm}")
    private String orderAutoConfirm;

    @GetMapping("/config")
    public String config(){
        return "orderTimeout:"+orderTimeout+"; orderAutoConfirm:"+orderAutoConfirm;
    }


    @GetMapping("/create")
    public Order getOrder(@RequestParam("productId") Long productId,@RequestParam("userId") Long userId) {
        return orderService.craeteOrder(productId, userId);
    }
}