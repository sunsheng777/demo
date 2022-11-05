package com.sunsheng.project.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunsheng.project.user.dao.UserMapper;
import com.sunsheng.project.user.entity.UserEntity;
import com.sunsheng.project.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PC
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Override
    public List<UserEntity> getTestById(int i) {
        return baseMapper.getTestById(i);
    }
}
