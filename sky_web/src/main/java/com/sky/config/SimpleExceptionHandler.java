package com.sky.config;

import com.sky.common.entity.Result;
import com.sky.common.enums.ResultEnum;
import com.sky.common.exception.ApplicationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SimpleExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result exceptionHandler(RuntimeException e) {
        if (e instanceof ApplicationException) {
            return new Result(((ApplicationException) e).getErrorCode(), ((ApplicationException) e).getErrorMsg(),
                    ((ApplicationException) e).getData());
        } else {
            e.printStackTrace();
            return new Result(ResultEnum.UNKNOW_ERROR);
        }
    }
}
