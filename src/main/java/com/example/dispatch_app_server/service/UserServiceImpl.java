package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.mapper.UserMapper;
import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public int insertUser(UserDao userDao) {
        return userMapper.insert(userDao);
    }
}
