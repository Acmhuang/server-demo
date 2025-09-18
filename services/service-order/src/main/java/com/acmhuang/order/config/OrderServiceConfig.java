package com.acmhuang.order.config;

import feign.Logger;
import feign.RetryableException;
import feign.Retryer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Acmhuang
 * @date 2025/09/17 15:14
 **/
@Configuration
public class OrderServiceConfig {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
//    @Bean
    Retryer retryer(){
        return new Retryer.Default();
    }
}