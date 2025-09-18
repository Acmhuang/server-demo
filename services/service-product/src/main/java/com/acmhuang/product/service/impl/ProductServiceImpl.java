package com.acmhuang.product.service.impl;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import com.acmhuang.product.bean.Product;
import com.acmhuang.product.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author Acmhuang
 * @date 2025/09/17 13:33
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProduct(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("99"));
        product.setProductName("苹果"+product);
        product.setNum(2);
        try{
            TimeUnit.SECONDS.sleep(100);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        return product;
    }
}