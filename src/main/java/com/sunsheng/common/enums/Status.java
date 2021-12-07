package com.sunsheng.common.enums;
public enum Status {
    STATUS_NORMAL(0,"正常"),
    ;

    private Integer code;

    private String name;


    Status(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
