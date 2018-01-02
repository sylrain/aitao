package com.aitao.domain.po;

import lombok.Data;

import java.util.Date;

/**
 * Created by sunyu on 2017/9/2.
 */
@Data
public class User {
    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 账号名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 支付宝账号
     */
    private String ali;

    /**
     * 微信账号
     */
    private String wechat;

    /**
     * 0不可登录 1正常
     */
    private Integer state;

    /**
     *添加时间
     */
    private Date addTime;

    /**
     *
     */
    private String token;
}
