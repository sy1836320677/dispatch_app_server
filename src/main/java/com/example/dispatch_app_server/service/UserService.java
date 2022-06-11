package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;

import java.util.List;

public interface UserService {
    int insertUser(UserDao userDao);

    int deleteUserById(Integer id);

    int updateUserById(UserDao userDao);

    List<UserDao> getAllUsers();

    List<UserDao> searchUser(Integer id, String skill, String name, Integer power, Integer type);

}
