package com.sky.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sky.common.enums.ResultEnum;
import com.sky.common.exception.ApplicationException;
import com.sky.demo.dao.IUserDao;
import com.sky.demo.entity.User;
import com.sky.demo.entity.UserSearch;
import com.sky.demo.repository.IUserRepository;
import com.sky.demo.service.IUserService;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(version = "1.0.0")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;
    @Resource
    private IUserRepository userRepository;

//    @Cacheable(value = "user", key = "'list'")
    @Override
    public List<User> getUserList() {
        Iterable<UserSearch> userSearches = userRepository.findAll();

        for (UserSearch item : userSearches) {
            System.out.println("Id:" + item.getId() +"; name:" + item.getName() + "; title:" + item.getTitle());
        }
        System.out.println("==========================");
        userSearches = userRepository.search(new QueryStringQueryBuilder("圾4"));
        for (UserSearch item : userSearches) {
            System.out.println("Id:" + item.getId() +"; name:" + item.getName() + "; title:" + item.getTitle());
        }

        return userDao.selectUserList();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        UserSearch userSearch;

        userDao.insertUser(user);

        userSearch = new UserSearch();
        userSearch.setId(user.getId());
        userSearch.setName(user.getName());
        userSearch.setTitle(user.getTitle());
        userRepository.save(userSearch);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void delUser(long id) {

    }
}
