package com.acmhuang.order.feign;

import com.acmhuang.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//说明是一个Feign客户端用于发送远程请求
@FeignClient(value = "service-product")
public interface ProductFeignClient {


    //mvc注解的两套使用逻辑
    //1.标注在Controller上，是接受这样的请求
    //2.标注在FeignClient上，是发送这样的请求
    @GetMapping("/product/getProduct/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
