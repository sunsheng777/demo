package com.sunsheng.project.clickhouse.entity;

import lombok.Data;

@Data
public class UserInfo {
    private int id;
    private String userName;
    private String passWord;
    private String phone;
    private String createDay;
}
