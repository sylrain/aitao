package com.aitao.domain.po;

import lombok.Data;

import java.util.Date;

/**
 * Created by sunyu on 2017/9/9.
 */
@Data
public class OrderDeal {
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

    /**
     * 返利渠道
     */
    private String returnChannel;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 处理时间
     */
    private Date dealTime;
}
