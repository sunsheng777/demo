package com.sunsheng.modules.sql.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunsheng.modules.sql.dao.UserMapper;
import com.sunsheng.modules.sql.entity.UserEntity;
import com.sunsheng.modules.sql.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Override
    public List<UserEntity> getInfo() {
        return baseMapper.getInfo();
    }

    @Override
    public List<UserEntity> getTest() {
        return baseMapper.getTest();
    }
}
