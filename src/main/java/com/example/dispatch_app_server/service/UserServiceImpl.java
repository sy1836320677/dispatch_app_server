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
    public List<UserDao> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public List<UserDao> getUsersBySkill(String skill) {
        return userMapper.getUserBySkill(skill);
    }

    @Override
    public List<UserDao> getUsersByWorkArea(int workArea) {
        return userMapper.getUserByWorkArea(workArea);
    }

    @Override
    public List<UserDao> getUsersType(int type) {
        return userMapper.getUserByType(type);
    }

    @Override
    public int updateUserById(UserDao userDao) {
        return userMapper.updateUserById(userDao);
    }

    @Override
    public List<UserDao> getUsersByPower(int power) {
        return userMapper.getUsersByPower(power);
    }

    @Override
    public UserDao getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
