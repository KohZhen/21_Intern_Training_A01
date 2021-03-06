package com.puzzle.utils;

public enum Status {

    SUCCESS(400,"操作成功"),
    ERROR(505,"操作失败"),
    NO_AUTH(301,"没有权限"),
    TOKEN_ERROR(404,"超时或者不合法的token");

    private Integer code;
    private String msg;

    Status(Integer code, String msg) {
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
