package com.acmhuang.order;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author Acmhuang
 * @date 2025/09/05 14:42
 **/
@SpringBootApplication
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class, args);
    }


    /**
     * 监听nacos配置文件变化
     * @param manager
     * @return
     */
    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager manager) {
        return args -> {
            ConfigService configService = manager.getConfigService();
            configService.addListener(
                    "service-order.yml",
                    "DEFAULT_GROUP",
                    new Listener() {
                        @Override
                        public Executor getExecutor() {
                            return Executors.newFixedThreadPool(7);
                        }

                        @Override
                        public void receiveConfigInfo(String configInfo) {
                            System.out.println("变化的配置信息" + configInfo);
                            System.out.println("邮件通知...");
                        }
                    }
            );
            System.out.println("==================================");
        };
    }
}