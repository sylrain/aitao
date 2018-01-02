package com.aitao.service.impl;

import com.aitao.dao.BaseMapper;
import com.aitao.domain.condition.BaseCondition;
import com.aitao.domain.exception.AiTaoException;
import com.aitao.service.BaseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sunyu on 2017/8/18.
 */
public abstract class BaseServiceImpl<T,C extends BaseCondition,M extends BaseMapper<T, C>> implements BaseService<T,C> {
    // Class <T>  entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Autowired
    private M mapper;

    @Override
    public T query(Object id) {
        T o = mapper.select(id);
        return o;
    }

    @Override
    public T queryWithValid(Object id) throws AiTaoException {
        T o = mapper.select(id);
        if (o == null){
            throw new AiTaoException(id + "对应的记录为空");
        }
        return o;
    }

    @Override
    public List<T> queryList(C condition) {
        PageHelper.startPage(condition.getPageNum(),condition.getPageSize(),false);
        List<T> list = mapper.selectList(condition);
        return list;
    }

    @Override
    public int queryCount(C baseCondition) {
        return mapper.count(baseCondition);
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int update(T po) {
        int row = mapper.update(po);
        return row;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateWithValid(T po) throws AiTaoException {
        int row = mapper.update(po);
        if (row == 0) {
            throw new AiTaoException("修改失败");
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insert(T po) {
        mapper.insert(po);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void delete(Object id) {
        mapper.delete(id);
    }



    /**
     * 返回对应的Mapper
     *
     * @return
     */
    protected M getMapper() {
        return mapper;
    }
}
