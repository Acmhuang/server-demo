package com.acmhuang.order.feign.fallback;
import java.math.BigDecimal;

import com.acmhuang.order.feign.ProductFeignClient;
import com.acmhuang.product.bean.Product;
import org.springframework.stereotype.Component;

/**
 * @author Acmhuang
 * @date 2025/09/18 16:25
 **/
@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product getProductById(Long id) {
        System.out.println("兜底回调.....");
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal("0"));
        product.setProductName("unknown");
        product.setNum(0);
        return product;
    }
}