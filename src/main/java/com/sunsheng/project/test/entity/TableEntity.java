package com.sunsheng.project.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author PC
 */
@TableName("user_table")
@Data
public class TableEntity {
    @TableId
    private String id;
    private String tableName;
}
