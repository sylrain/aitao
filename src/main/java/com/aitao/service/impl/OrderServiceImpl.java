package com.aitao.service.impl;

import com.aitao.dao.OrderMapper;
import com.aitao.domain.condition.OrderCondition;
import com.aitao.domain.po.Order;
import com.aitao.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * Created by sunyu on 2017/9/9.
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order,OrderCondition,OrderMapper> implements OrderService{
    @Override
    public Order queryByOrderId(String orderId) {
        return this.getMapper().queryByOrderId(orderId);
    }
}
