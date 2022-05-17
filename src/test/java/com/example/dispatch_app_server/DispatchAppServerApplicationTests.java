package com.example.dispatch_app_server;

import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;
import com.example.dispatch_app_server.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DispatchAppServerApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
    }

    @Test
    void testInsert() {
        UserDao userDao = new UserDao();
        userDao.setName("Lisa");
        userService.insertUser(userDao);
    }
}
