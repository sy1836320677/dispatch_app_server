package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;

public interface UserService {
    int insertUser(UserDao userDao);
}
