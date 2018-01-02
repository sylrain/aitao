package com.aitao.service.impl;

import com.aitao.dao.VersionMapper;
import com.aitao.domain.po.Version;
import com.aitao.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunyu on 2017/9/9.
 */
@Service
public class VersionServiceImpl implements VersionService {
    @Autowired
    private VersionMapper versionMapper;
    @Override
    public Version query() {
        return versionMapper.query();
    }
}
