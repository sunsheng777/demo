package com.sunsheng.project.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunsheng.project.test.dao.AllTableMapper;
import com.sunsheng.project.test.entity.AllTableEntity;
import com.sunsheng.project.test.service.AllTableService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PC
 */
@Service
public class AllTableServiceImpl extends ServiceImpl<AllTableMapper, AllTableEntity> implements AllTableService {
    @Override
    public List<AllTableEntity> getByTableName(@Param("tableName") String tableName) {
        return baseMapper.getByTableName(tableName);
    }
}
