package com.sky.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sky.demo.entity.User;
import com.sky.demo.service.IUserSerivce;

import java.util.List;

@Service(version = "1.0.0")
public class UserServiceImpl implements IUserSerivce {
    @Override
    public List<User> getUserList() {
        return null;
    }
}
