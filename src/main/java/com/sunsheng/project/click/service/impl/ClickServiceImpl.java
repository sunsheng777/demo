package com.sunsheng.project.click.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunsheng.project.click.dao.ClickMapper;
import com.sunsheng.project.click.entity.ClickEntity;
import com.sunsheng.project.click.service.ClickService;
import org.springframework.stereotype.Service;

/**
 * @author PC
 */
@Service
public class ClickServiceImpl extends ServiceImpl<ClickMapper, ClickEntity> implements ClickService {
    @Override
    public ClickEntity getTestById(Integer id) {
        return baseMapper.getTestById(id);
    }

    @Override
    public void saveData(ClickEntity click) {
        baseMapper.insert(click);
    }
}
