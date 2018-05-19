package com.sky.demo.service;

import com.sky.demo.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getUserList();

    void addUser(User user);

    void updateUser(User user);

    void delUser(long id);
}
