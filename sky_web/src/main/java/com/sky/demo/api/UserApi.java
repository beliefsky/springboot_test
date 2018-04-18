package com.sky.demo.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sky.common.entity.Result;
import com.sky.common.enums.ResultEnum;
import com.sky.demo.service.IUserSerivce;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class UserApi {

    @Reference(version = "1.0.0")
    private IUserSerivce userSerivce;

    @GetMapping("/test")
    public Result getUsers() {
        return new Result(ResultEnum.QUERY_SUCCESS, userSerivce.getUserList());
    }
}