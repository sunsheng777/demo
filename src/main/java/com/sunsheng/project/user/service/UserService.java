package com.sunsheng.project.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sunsheng.project.user.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PC
 */
@Service
public interface UserService extends IService<UserEntity> {

    List<UserEntity> getTestById(int i);
}