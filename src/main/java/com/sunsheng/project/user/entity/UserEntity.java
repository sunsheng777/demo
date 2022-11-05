package com.sunsheng.project.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author PC
 */
@TableName("user")
@Data
public class UserEntity {
    @TableId
    private String id;
    private String name;
}
