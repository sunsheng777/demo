package com.sunsheng.modules.clickt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sunsheng.modules.clickt.entity.ClickEntity;
import com.sunsheng.project.test.entity.TableEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PC
 */
@Service
public interface ClickService{
    ClickEntity getTestById(Integer id);

    void saveData(ClickEntity click);
}