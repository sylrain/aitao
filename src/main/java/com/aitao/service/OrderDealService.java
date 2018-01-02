package com.aitao.service;

import com.aitao.domain.condition.OrderDealCondition;
import com.aitao.domain.po.OrderDeal;
import com.aitao.domain.po.OrderInfo;

import java.util.List;

/**
 * Created by sunyu on 2017/9/9.
 */
public interface OrderDealService extends BaseService<OrderDeal,OrderDealCondition>{
    /**
     * info列表
     * @param condition
     * @return
     */
    List<OrderInfo> queryInfoList(OrderDealCondition condition);
}
