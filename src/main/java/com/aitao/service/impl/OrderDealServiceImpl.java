package com.aitao.service.impl;

import com.aitao.dao.OrderDealMapper;
import com.aitao.domain.condition.OrderDealCondition;
import com.aitao.domain.po.OrderDeal;
import com.aitao.domain.po.OrderInfo;
import com.aitao.service.OrderDealService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sunyu on 2017/9/9.
 */
@Service
public class OrderDealServiceImpl extends BaseServiceImpl<OrderDeal,OrderDealCondition,OrderDealMapper> implements OrderDealService {
    @Override
    public List<OrderInfo> queryInfoList(OrderDealCondition condition) {
        PageHelper.startPage(condition.getPageNum(),condition.getPageSize(),false);
        return this.getMapper().queryInfoList(condition);
    }
}
