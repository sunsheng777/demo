package com.sunsheng.modules.sql.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sunsheng.modules.sql.entity.UserEntity;

import java.util.List;

public interface UserService extends IService<UserEntity> {
    List<UserEntity> getInfo();

    List<UserEntity> getTest();

}