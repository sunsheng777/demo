package com.sunsheng.project.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunsheng.project.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author PC
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    List<UserEntity> getTestById(int i);
}

