package com.sunsheng.project.click.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String userName;
    private String passWord;
    private String phone;
    private String email;
    private String createDay;
}