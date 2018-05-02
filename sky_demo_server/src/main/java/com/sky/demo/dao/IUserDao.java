package com.sky.demo.dao;

import com.sky.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    @Select("SELECT id, `name` FROM userindustry LIMIT 10")
    List<User> selectUserList();
}
