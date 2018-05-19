package com.sky.demo.dao;

import com.sky.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    @Select("SELECT id, `name`, title FROM tb_demo LIMIT 10")
    List<User> selectUserList();

    @Insert({
            "INSERT INTO tb_demo(`name`, title) VALUES(#{data.name}, #{data.title})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "data.id")
    void insertUser(@Param("data") User user);
}
