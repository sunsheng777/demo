package com.sunsheng.project.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunsheng.project.entity.BookEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author PC
 */
@Mapper
public interface BookMapper extends BaseMapper<BookEntity> {
}

