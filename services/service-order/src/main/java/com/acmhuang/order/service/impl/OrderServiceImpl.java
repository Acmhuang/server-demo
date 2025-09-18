package com.acmhuang.order.service.impl;
import java.math.BigDecimal;
import java.util.List;

import com.acmhuang.order.bean.Order;
import com.acmhuang.order.feign.ProductFeignClient;
import com.acmhuang.order.service.OrderService;
import com.acmhuang.product.bean.Product;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.nacos.shaded.com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Acmhuang
 * @date 2025/09/17 14:13
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private ProductFeignClient productFeignClient;

    @SentinelResource(value = "createOrder",blockHandler = "createOrderFallback")
    @Override
    public Order craeteOrder(Long productId, Long userId) {
        Order order = new Order();
        //Product product = getProductFromRemoteWithAnnotation(productId);
        Product product = productFeignClient.getProductById(productId);
        order.setId(1L);
        order.setTotalPrice(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickName("ming");
        order.setAddress("github");
        order.setProductList(List.of(product));
        return order;
    }

    //兜底回调
    public Order createOrderFallback(Long productId, Long userId, BlockException e) {
        Order order = new Order();
        order.setId(0L);
        order.setTotalPrice(new BigDecimal("0"));
        order.setUserId(userId);
        order.setNickName("unknown");
        order.setAddress("unknown");
        return order;
    }

    // 不使用@LoadBalanced注解
    private Product getProductFromRemote(Long productId) {
        //1.获取到商品服务所在的所有机器的IP+端口号
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        ServiceInstance serviceInstance = instances.get(0);
        String url = loadBalancerClient.choose("service-product").getUri() + "/product/getProduct/" + productId;
        log.info("请求商品服务：{}", url);
        //2.调用商品服务
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    // 使用@LoadBalanced注解
    private Product getProductFromRemoteWithAnnotation(Long productId) {
        String url = "http://service-product/product/getProduct/" + productId;
        log.info("请求商品服务：{}", url);
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }
}