package com.sunsheng.project.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunsheng.project.test.dao.TableMapper;
import com.sunsheng.project.test.entity.TableEntity;
import com.sunsheng.project.test.service.TableService;
import org.springframework.stereotype.Service;

/**
 * @author PC
 */
@Service
public class TableServiceImpl extends ServiceImpl<TableMapper, TableEntity> implements TableService {
    @Override
    public TableEntity getByIdTest() {
        return baseMapper.getByIdTest();
    }
}
