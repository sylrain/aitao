package com.aitao.domain.po;

import lombok.Data;

/**
 * Created by sunyu on 2017/9/9.
 */
@Data
public class OrderInfo {
    private Integer id;

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
     *
     */
    private String ordername;

    /**
     *
     */
    private String orderid;

    /**
     *
     */
    private String orderdate;

    /**
     *
     */
    private String paymoney;

    /**
     *
     */
    private String incomemoney;

    /**
     *
     */
    private String incomepercent;

    /**
     *
     */
    private String ratemoney;

    /**
     *
     */
    private String ratepercent;

}
