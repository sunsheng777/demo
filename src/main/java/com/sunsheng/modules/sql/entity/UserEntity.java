package com.sunsheng.modules.sql.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")
@Data
public class UserEntity {
    @TableId
    private String id;
    private String name;
}
