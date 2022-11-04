package com.sunsheng.project.click.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunsheng.project.click.dao.UserInfoMapper;
import com.sunsheng.project.click.entity.UserInfo;
import com.sunsheng.project.click.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author: tonghp
 * @create: 2021/07/26 16:48
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public void saveData(UserInfo userInfo) {
        userInfoMapper.saveData(userInfo);
    }
    @Override
    public UserInfo selectById(Integer id) {
        return userInfoMapper.selectById(id);
    }
    @Override
    public List<UserInfo> selectList() {
        return userInfoMapper.selectList();
    }
}
