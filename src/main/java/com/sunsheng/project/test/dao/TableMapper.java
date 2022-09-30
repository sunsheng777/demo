package com.sunsheng.project.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunsheng.project.test.entity.TableEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author PC
 */
@Mapper
public interface TableMapper extends BaseMapper<TableEntity> {
    TableEntity getByIdTest();
}

