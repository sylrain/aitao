package com.aitao.dao;

import com.aitao.domain.condition.UserCondition;
import com.aitao.domain.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sunyu on 2017/9/2.
 */
public interface UserMapper extends BaseMapper<User,UserCondition>{

    User queryByNickName(@Param("name")String name);

    User queryByAli(@Param("ali")String ali);

    User queryByWechat(@Param("wechat")String wechat);

    void batchInsert(List<User> list);
}
