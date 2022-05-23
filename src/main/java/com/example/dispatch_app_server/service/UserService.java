package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;

import java.util.List;

public interface UserService {
    int insertUser(UserDao userDao);

    int deleteUserById(int id);

    int updateUserById(UserDao userDao);

    List<UserDao> getAllUsers();

    UserDao getUserById(int id);

    List<UserDao> getUsersBySkill(String skill);

    List<UserDao> getUsersByWorkArea(int workArea);

    List<UserDao> getUsersByName(String name);

    List<UserDao> getUsersByPower(int power);

    List<UserDao> getUsersType(int type);

}
