package com.sunsheng.project.click.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sunsheng.project.click.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserInfoService extends IService<UserInfo> {
    void saveData(UserInfo userInfo);

    UserInfo selectById(@Param("id") Integer id);

    List<UserInfo> selectList();
}
