package com.sunsheng.project.book.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author PC
 */
@TableName("book")
@Data
public class BookEntity {
    @TableId
    private String id;
    private String name;
}
