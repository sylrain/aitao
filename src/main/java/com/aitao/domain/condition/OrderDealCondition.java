package com.aitao.domain.condition;

import lombok.Data;

/**
 * Created by sunyu on 2017/9/9.
 */
@Data
public class OrderDealCondition extends BaseCondition{
    /**
     * 订单编号
     */
    private Integer id;

    /**
     * 用户编号
     */
    private Integer uid;

    /**
     * 0未处理 1处理成功 2不通过
     */
    private Integer state;
}
