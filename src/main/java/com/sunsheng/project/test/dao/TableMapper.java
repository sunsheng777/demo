package com.sunsheng.project.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunsheng.project.test.entity.TableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author PC
 */
@Mapper
public interface TableMapper extends BaseMapper<TableEntity> {
    List<TableEntity> getByIdTest();
}

