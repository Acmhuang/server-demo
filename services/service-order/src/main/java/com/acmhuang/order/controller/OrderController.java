package com.acmhuang.order.controller;

import com.acmhuang.order.bean.Order;
import com.acmhuang.order.service.OrderService;
import com.acmhuang.order.yaml.OrderYaml;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Acmhuang
 * @date 2025/09/17 14:13
 **/
//激活配置文件刷新
//@RefreshScope
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

//    @Value("${order:timeout}")
//    private String orderTimeout;
//
//    @Value("${order:auto-confirm}")
//    private String orderAutoConfirm;
    @Autowired
    private OrderYaml orderYaml;


    @GetMapping("/config")
    public String config(){
        return "orderTimeout:"+orderYaml.getTimeout()
                +"; orderAutoConfirm:"+orderYaml.getAutoConfirm()
                + "; orderDbUrl:"+orderYaml.getDbUrl();
    }


    @GetMapping("/create")
    public Order getOrder(@RequestParam("productId") Long productId,
                          @RequestParam("userId") Long userId) {
        return orderService.craeteOrder(productId, userId);
    }

    @GetMapping("/seckill")
    public Order seckill(@RequestParam("productId") Long productId,
                          @RequestParam("userId") Long userId) {
        Order order = orderService.craeteOrder(productId, userId);
        order.setId(Long.MAX_VALUE);
        return order;
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @GetMapping("/read")
    public String read() {
        log.info("reading Database");
        return "read";
    }
}