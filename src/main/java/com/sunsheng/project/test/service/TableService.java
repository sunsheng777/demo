package com.sunsheng.project.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sunsheng.project.test.entity.TableEntity;

import java.util.List;

/**
 * @author PC
 */
public interface TableService extends IService<TableEntity> {

    List<TableEntity> getByIdTest();

}