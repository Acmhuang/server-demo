package com.acmhuang.order;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.net.URI;

/**
 * @author Acmhuang
 * @date 2025/09/17 16:50
 **/
@SpringBootTest
public class LoadBalancerTest {

    @Resource
    LoadBalancerClient loadBalancerClient;

    @Test
    void testLoadBalancer() {
        URI uri = loadBalancerClient.choose("service-product").getUri();
        System.out.println(uri);
        uri = loadBalancerClient.choose("service-product").getUri();
        System.out.println(uri);
        uri = loadBalancerClient.choose("service-product").getUri();
        System.out.println(uri);
    }

}