package com.aitao.service.impl;

import com.aitao.dao.UserMapper;
import com.aitao.domain.condition.UserCondition;
import com.aitao.domain.po.User;
import com.aitao.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyu on 2017/9/2.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserCondition,UserMapper> implements UserService{


    @Override
    public User queryByNickName(String nickName) {
        return this.getMapper().queryByNickName(nickName);
    }

    @Override
    public User queryByAli(String ali) {
        return this.getMapper().queryByAli(ali);
    }

    @Override
    public User queryByWechat(String wechat) {
        return this.getMapper().queryByWechat(wechat);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void batchInsert() {
        for (int i = 0; i< 2; i++){
            User user = new User();
            user.setName("111");
            this.getMapper().insert(user);
            System.out.println(user.getId());
        }
    }

    @Override
    public void batchInsertUser() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i< 2; i++){
            User user = new User();
            user.setName("222");
            list.add(user);
        }
        this.getMapper().batchInsert(list);
        for (User user : list){
            System.out.println(user.getId());
        }
    }

}
