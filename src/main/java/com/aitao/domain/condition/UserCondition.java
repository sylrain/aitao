package com.aitao.domain.condition;

import lombok.Data;

/**
 * Created by sunyu on 2017/9/2.
 */
@Data
public class UserCondition extends BaseCondition{
    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 账号名
     */
    private String name;

    /**
     * 支付宝账号
     */
    private String ali;

    /**
     * 微信账号
     */
    private String wechat;
    /**
     *
     */
    private String token;
}
