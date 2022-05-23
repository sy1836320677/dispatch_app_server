package com.example.dispatch_app_server.controller;

import com.example.dispatch_app_server.commons.web.ResponseResult;
import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;
import com.example.dispatch_app_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("")
    public ResponseResult addUser(@RequestBody UserDao userDao) {
        int res = userService.insertUser(userDao);
        if (res < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteUserById(@PathVariable int id) {
        int res = userService.deleteUserById(id);
        if (res < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult();
        }
    }

    @PutMapping("")
    public ResponseResult updateById(@RequestBody UserDao user) {
        int affectedRowsSum = userService.updateUserById(user);
        if (affectedRowsSum < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult();
        }
    }

    @GetMapping("")
    public ResponseResult<List<UserDao>> getAllUsers() {
        List<UserDao> userDaoList = userService.getAllUsers();
        if (userDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(userDaoList);
        }
    }

    @GetMapping("/{id}")
    public ResponseResult<UserDao> getUserById(@PathVariable int id) {
        UserDao userDao = userService.getUserById(id);
        if (userDao != null) {
            return ResponseResult.newSuccessResult(userDao);
        } else {
            return ResponseResult.newFailResult();
        }
    }

    @GetMapping("/skill/{skill}")
    public ResponseResult<List<UserDao>> getUsersBySkill(@PathVariable String skill) {
        List<UserDao> userDaoList = userService.getUsersBySkill(skill);
        if (userDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(userDaoList);
        }
    }

    @GetMapping("/workArea/{workArea}")
    public ResponseResult<List<UserDao>> getUsersByWorkArea(@PathVariable int workArea) {
        List<UserDao> userDaoList = userService.getUsersByWorkArea(workArea);
        if (userDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(userDaoList);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseResult<List<UserDao>> getUsersByName(@PathVariable String name) {
        List<UserDao> userDaoList = userService.getUsersByName(name);
        if (userDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(userDaoList);
        }
    }

    @GetMapping("/power/{power}")
    public ResponseResult<List<UserDao>> getUsersByPower(@PathVariable int power) {
        List<UserDao> userDaoList = userService.getUsersByPower(power);
        if (userDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(userDaoList);
        }
    }

    @GetMapping("/type/{type}")
    public ResponseResult<List<UserDao>> getUsersByType(@PathVariable int type) {
        List<UserDao> userDaoList = userService.getUsersType(type);
        if (userDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(userDaoList);
        }
    }


}
