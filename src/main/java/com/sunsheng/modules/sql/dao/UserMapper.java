package com.sunsheng.modules.sql.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunsheng.modules.sql.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    List<UserEntity> getInfo();

    List<UserEntity> getTest();
}

