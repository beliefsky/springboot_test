package com.sky.common.enums;

public enum ResultEnum {

    SUCCESS(200, "操作成功"),
    QUERY_SUCCESS(200, "查询成功"),
    QUERY_NO_FOUND(201, "数据不存在"),
    LOGIN_SUCCESS(200, "登录成功"),
    DATA_FORBIDDEN(206, "非法输入"),
    DEAL_FAIL(207, "操作失败"),
    UNKNOW_ERROR(500, "内部错误"),
    LOW_STOCKS(208, "库存不足"),

    PARAM_MISSING(1000, "请求参数%s缺失"),
    PARAM_PATTERN_ERROR(1001, "请求参数格式错误"),
    PARAM_NULL_ERROR(1002, "请求参数%s不能为空"),
    PARAM_FORMAT_ERROR(1003, "请求参数%s格式错误"),
    DATE_PATTERN_ERROR(1004, "日期字符串格式错误"),
    PARAM_STRING_LENGTH_ERROR(1005, "请求参数%s不能超过%d个字符"),

    //用户模块异常
    NO_LOGIN(401, "用户未登录"),
    LOGIN_ERROR(402, "用户名或者密码错误"),
    DEAL_FORBIDDEN(403, "无操作权限"),
    LOGIN_FAINLED(405, "注册失败"),
    OLDPWD_ERROR(4001, "原密码有误"),
    NEWPWD_ERROR(4002, "两次密码不一致"),
    UPDATE_FAINLED(406, "修改失败"),
    DELETE_FAINLED(408, "删除失败"),
    INSERT_FAINLED(407, "添加失败"),
    UID_REPEAT(409, "帐号已存在"),
    USER_MAX(410, "账户数已达到上限"),
    PACKAGE_NO_FIND(411, "未购买套餐"),
    PACKAGE_TIMEOUT(412, "套餐已过期"),
    PACKAGE_USER_MAX(413, "已达到最大用户数"),
    PACKAGE_FORBIDDEN(414, "套餐被禁用"),
    PACKAGE_NO_START(415, "套餐未开始"),
    USER_REPEAT(416, "用户已存在"),

    CODE_REPEAT(409, "编号已存在"), //物料或成品编号已存在
    ODDNUMBERS_REPEAT(409, "单号已存在"),
    NEED_CODE_REPEAT(409, "需方图号已经与成品绑定"),
    //PDA
    PRODUCT_TASK_UNCOMPLETE(405,"成品质检信息不完整"),
    TASK_IS_END(406, "任务已完成"),
    PDA_NO_FOUND(404, "PDA不存在"),
    EMAIL_SEND_ERROR(410, "邮件发送失败"),
    ORDER_CONFIRM_FAIL(417, "订单确认失败");
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
