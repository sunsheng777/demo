package com.sunsheng.project.click.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class ClickEntity {
    @TableId("id")
    private Integer id;
    private String name;
    private Integer age;
}
