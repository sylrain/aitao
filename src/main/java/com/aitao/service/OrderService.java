package com.aitao.service;

import com.aitao.domain.condition.OrderCondition;
import com.aitao.domain.po.Order;

/**
 * Created by sunyu on 2017/9/9.
 */
public interface OrderService extends BaseService<Order,OrderCondition>{

    Order queryByOrderId(String orderId);
}
