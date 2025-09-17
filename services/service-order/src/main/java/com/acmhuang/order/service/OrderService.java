package com.acmhuang.order.service;

import com.acmhuang.order.bean.Order;

/**
 * @author Acmhuang
 * @date 2025/09/17 14:12
 **/
public interface OrderService {
    Order craeteOrder(Long productId, Long userId);
}