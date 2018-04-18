package com.sky.common.exception;

import com.sky.common.enums.ResultEnum;

public class ApplicationException extends RuntimeException {

    private final int errorCode;
    private final String errorMsg;
    private final Object data;


    public ApplicationException(ResultEnum validation) {
        super();
        this.errorCode = validation.getCode();
        this.errorMsg = validation.getDesc();
        this.data = null;
    }


    public ApplicationException(int errorCode, String errorDesc) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorDesc;
        this.data = null;
    }

    public ApplicationException(ResultEnum validation, Object data) {
        super();
        this.errorCode = validation.getCode();
        this.errorMsg = validation.getDesc();
        this.data = data;
    }


    public ApplicationException(int errorCode, String errorDesc, Object data) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorDesc;
        this.data = data;
    }

    /**
     * 获取错误代码
     *
     * @return 错误码
     */
    public int getErrorCode() {
        return this.errorCode;
    }

    /**
     * 获取错误提示信息
     *
     * @return 错误信息
     */
    public String getErrorMsg() {
        return this.errorMsg;
    }

    /**
     * 返回异常后的数据
     *
     * @return 异常信息
     */
    public Object getData() {
        return data;
    }
}
