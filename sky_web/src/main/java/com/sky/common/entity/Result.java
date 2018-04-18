package com.sky.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sky.common.enums.ResultEnum;

/**
 * Created with IntelliJ IDEA
 *
 * @Author weijing
 * @Date 2016/7/21
 * @Time 17:01
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private final int status;
    private final String message;
    private final Object data;

    public Result(ResultEnum resultEnum) {
        this.status = resultEnum.getCode();
        this.message = resultEnum.getDesc();
        this.data = null;
    }

    public Result(ResultEnum resultEnum, Object data) {
        if (data != null) {
            this.status = resultEnum.getCode();
            this.message = resultEnum.getDesc();
        } else {
            this.status = ResultEnum.QUERY_NO_FOUND.getCode();
            this.message = ResultEnum.QUERY_NO_FOUND.getDesc();
        }
        this.data = data;
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public Result(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
