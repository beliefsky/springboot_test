package com.sky.common.enums;

public enum ResultEnum {

    SUCCESS(200, "操作成功"),
    QUERY_SUCCESS(200, "查询成功"),
    QUERY_NO_FOUND(201, "数据不存在"),
    LOGIN_SUCCESS(200, "登录成功"),
    DATA_FORBIDDEN(206, "非法输入"),
    DEAL_FAIL(207, "操作失败"),
    UNKNOW_ERROR(500, "内部错误"),

    PARAM_MISSING(1000, "请求参数%s缺失"),
    PARAM_PATTERN_ERROR(1001, "请求参数格式错误"),
    PARAM_NULL_ERROR(1002, "请求参数%s不能为空"),
    PARAM_FORMAT_ERROR(1003, "请求参数%s格式错误"),
    DATE_PATTERN_ERROR(1004, "日期字符串格式错误"),
    PARAM_STRING_LENGTH_ERROR(1005, "请求参数%s不能超过%d个字符");

    private final String desc;
    private final int code;

    ResultEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
