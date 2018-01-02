package com.aitao.dao;

import com.aitao.domain.condition.OrderDealCondition;
import com.aitao.domain.po.OrderDeal;
import com.aitao.domain.po.OrderInfo;

import java.util.List;

/**
 * Created by sunyu on 2017/9/9.
 */
public interface OrderDealMapper extends BaseMapper<OrderDeal,OrderDealCondition>{

    List<OrderInfo> queryInfoList(OrderDealCondition condition);
}
