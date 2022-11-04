package com.sunsheng.project.click.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunsheng.project.click.entity.ClickEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author PC
 */
@Mapper
//@Repository
public interface ClickMapper extends BaseMapper<ClickEntity> {
    ClickEntity getTestById(@Param("id") Integer id);

}

