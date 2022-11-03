package com.sunsheng.modules.clickt.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunsheng.modules.clickt.entity.ClickEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author PC
 */
@Mapper
//@Repository
public interface ClickMapper extends BaseMapper<ClickEntity> {
    ClickEntity getTestById(@Param("id") Integer id);

}

