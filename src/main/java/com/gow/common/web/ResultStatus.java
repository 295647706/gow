package com.gow.common.web;

public enum ResultStatus {

    SUCCESS(0,"执行成功"),
    UNKONW_ERROR(-1, "未知错误"),
    SQL_SYNTAX_ERROR(-2, "SQL语法错误"),

    ;

    private Integer code;
    private String msg;

    ResultStatus(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
