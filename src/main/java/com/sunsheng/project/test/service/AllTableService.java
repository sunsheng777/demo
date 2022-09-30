package com.sunsheng.project.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sunsheng.project.test.entity.AllTableEntity;

/**
 * @author PC
 */
public interface AllTableService extends IService<AllTableEntity> {

    AllTableEntity getByTableName();

}