package com.sunsheng.project.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunsheng.project.test.entity.AllTableEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author PC
 */
@Mapper
public interface AllTableMapper extends BaseMapper<AllTableEntity> {
    List<AllTableEntity> getByTableName(@Param("tableName") String tableName);
}

