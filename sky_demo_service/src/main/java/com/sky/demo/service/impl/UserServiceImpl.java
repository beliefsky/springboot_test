package com.sky.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sky.demo.dao.IUserDao;
import com.sky.demo.entity.User;
import com.sky.demo.service.IUserSerivce;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(version = "1.0.0")
public class UserServiceImpl implements IUserSerivce {

    @Resource
    private IUserDao userDao;

    @Cacheable(value = "user", key = "'list'")
    @Transactional(readOnly = true)
    @Override
    public List<User> getUserList() {
        System.out.println("============================");
        return userDao.selectUserList();
    }
}
