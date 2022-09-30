package com.sunsheng.project.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sunsheng.project.test.entity.AllTableEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author PC
 */
public interface AllTableService extends IService<AllTableEntity> {


    List<AllTableEntity> getByTableName(@Param("tableName") String tableName);

}