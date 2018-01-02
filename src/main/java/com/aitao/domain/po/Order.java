package com.aitao.domain.po;

import lombok.Data;

/**
 * Created by sunyu on 2017/9/9.
 */
@Data
public class Order {
    /**
     *
     */
    private Integer id;

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

    /**
     *
     */
    private String orderstate;

    /**
     *
     */
    private String hasrate;
}
