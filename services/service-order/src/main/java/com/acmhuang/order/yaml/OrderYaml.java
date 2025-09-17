package com.acmhuang.order.yaml;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Acmhuang
 * @date 2025/09/17 18:58
 **/
@Data
@Component
//配置批量绑定在nacos下，可以无需@RefreshScope刷新
@ConfigurationProperties(prefix = "order")
public class OrderYaml {

    private String timeout;

    private String autoConfirm;
}