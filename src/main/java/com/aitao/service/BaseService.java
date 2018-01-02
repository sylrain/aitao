package com.aitao.service;

import com.aitao.domain.condition.BaseCondition;
import com.aitao.domain.exception.AiTaoException;

import java.util.List;

/**
 * Created by sunyu on 2017/8/18.
 */
public interface BaseService<T,C extends BaseCondition> {
    /**
     * 查询详情
     * @param id
     * @return
     */
    T query(Object id);

    /**
     * 查询验证的详情
     * @param id
     * @return
     */
    T queryWithValid(Object id) throws AiTaoException;

    /**
     * 查询列表
     * @param condition
     * @return
     */
    List<T> queryList(C condition);

    /**
     * 查询数量
     * @param condition
     * @return
     */
    int queryCount(C condition);

    /**
     * 修改
     *
     * @param po
     * @return
     */
    int update(T po);

    /**
     * 修改,失败则抛异常
     *
     * @param po
     * @throws AiTaoException
     */
    void updateWithValid(T po) throws AiTaoException;

    /**
     * 新增
     *
     * @param po
     */
    void insert(T po);

    /**
     * 删除
     * @param id
     * @throws AiTaoException
     */
    void delete(Object id) throws AiTaoException;
}
