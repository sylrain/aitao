package com.aitao.service;

import com.aitao.domain.condition.UserCondition;
import com.aitao.domain.po.User;

/**
 * Created by sunyu on 2017/9/2.
 */
public interface UserService extends BaseService<User,UserCondition>{
    User queryByNickName(String nickName);

    User queryByAli(String ali);

    User queryByWechat(String wechat);

    void batchInsert();

    void batchInsertUser();
}
