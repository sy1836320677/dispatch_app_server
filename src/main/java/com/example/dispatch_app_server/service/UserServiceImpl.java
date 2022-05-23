package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.mapper.UserMapper;
import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(UserDao userDao) {
        return userMapper.insertUser(userDao);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUserById(UserDao userDao) {
        return userMapper.updateUserById(userDao);
    }

    @Override
    public List<UserDao> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public List<UserDao> searchUser(Integer id, String skill, Integer workArea, String name, Integer power, Integer type) {
        return userMapper.searchUser(id, skill, workArea, name, power, type);
    }


}
