package com.acmhuang.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Acmhuang
 * @date 2025/09/18 16:07
 **/
@Component
public class XTokenRequestInterceptor implements RequestInterceptor {

    /**
     * 拦截器
     * @param requestTemplate 请求模板
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("X-Token");
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }
}