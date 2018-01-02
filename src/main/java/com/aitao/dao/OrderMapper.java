package com.aitao.dao;

import com.aitao.domain.condition.OrderCondition;
import com.aitao.domain.po.Order;
import org.apache.ibatis.annotations.Param;

/**
 * Created by sunyu on 2017/9/9.
 */
public interface OrderMapper extends BaseMapper<Order,OrderCondition>{

    Order queryByOrderId(@Param("orderid")String orderid);
}
