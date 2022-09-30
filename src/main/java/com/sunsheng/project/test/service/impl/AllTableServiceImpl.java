package com.sunsheng.project.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunsheng.project.test.dao.AllTableMapper;
import com.sunsheng.project.test.entity.AllTableEntity;
import com.sunsheng.project.test.service.AllTableService;
import org.springframework.stereotype.Service;

/**
 * @author PC
 */
@Service
public class AllTableServiceImpl extends ServiceImpl<AllTableMapper, AllTableEntity> implements AllTableService {
    @Override
    public AllTableEntity getByTableName() {
        return baseMapper.getByTableName();
    }
}
