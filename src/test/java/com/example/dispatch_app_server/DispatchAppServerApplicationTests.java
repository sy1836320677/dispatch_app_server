package com.example.dispatch_app_server;

import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;
import com.example.dispatch_app_server.dao.mysql.pojo.WorkAreaDao;
import com.example.dispatch_app_server.service.UserService;
import com.example.dispatch_app_server.service.WorkAreaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DispatchAppServerApplicationTests {
    @Autowired
    private UserService userService;

    @Autowired
    private WorkAreaService workAreaService;

    @Test
    void contextLoads() {
    }

    @Test
    void testInsert() {
        UserDao userDao = new UserDao();
        userDao.setName("李华");
        userService.insertUser(userDao);
    }

    @Test
    void testGet() {
        System.out.println(userService.getAllUsers());
        System.out.println(userService.getUsersBySkill("卡车"));
        System.out.println(userService.getUsersByWorkArea(1));
        System.out.println(userService.getUsersType(2));
        UserDao userDao = userService.getUserById(1);
        userDao.setSkill("运输工");
        userService.updateUserById(userDao);
        System.out.println(userService.getAllUsers());
    }

    @Test
    void testWorkAreaAdd() {
        WorkAreaDao workAreaDao = new WorkAreaDao();
        workAreaDao.setName("E");
        workAreaDao.setScope("休息区");
        workAreaService.insertWorkArea(workAreaDao);
        WorkAreaDao workAreaDao2 = new WorkAreaDao();
        workAreaDao.setName("F");
        workAreaDao.setScope("已完成区");
        workAreaService.insertWorkArea(workAreaDao);
        WorkAreaDao workAreaDao3 = new WorkAreaDao();
        workAreaDao.setName("G");
        workAreaDao.setScope("丘陵区");
        workAreaService.insertWorkArea(workAreaDao);
        System.out.println(workAreaService.getAllWorkAreas());
    }
    @Test
    void testWorkAreaGet() {

    }
}
