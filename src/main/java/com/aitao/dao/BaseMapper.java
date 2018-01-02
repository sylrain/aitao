package com.aitao.dao;


import com.aitao.domain.condition.BaseCondition;

import java.util.List;

/**
 * Created by Administrator on 2017/4/6.
 */
public interface BaseMapper<T,C extends BaseCondition> {
    /**
     * 获得bean
     *
     * @param id
     * @return
     */
    T select(Object id);
    /**
     * 获得数量
     *
     * @param condition
     * @return
     */
    int count(C condition);
    /**
     * 获得列表
     *
     * @param condition
     * @return
     */
    List<T> selectList(C condition);
    /**
     * 新增记录
     *
     * @param po
     */
    void insert(T po);
    /**
     * 修改记录
     *
     * @param po
     * @return
     */
    int update(T po);
    /**
     * 删除记录
     *
     * @param id
     * @return
     */
    int delete(Object id);
}
