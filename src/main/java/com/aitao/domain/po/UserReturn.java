package com.aitao.domain.po;

import lombok.Data;

@Data
public class UserReturn {
    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 账号名
     */
    private String name;
    /**
     * 0不可登录 1正常
     */
    private Integer state;
    /**
     *
     */
    private String token;
}
