package com.example.dispatch_app_server.controller;

import com.example.dispatch_app_server.commons.web.ResponseResult;
import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;
import com.example.dispatch_app_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("user")
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
    public ResponseResult deleteUserById(@PathVariable Integer id) {
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

    @GetMapping("/search")
    public ResponseResult<List<UserDao>> searchUsers(@RequestParam(required = false) Integer id,
                                                     @RequestParam(required = false) String skill,
                                                     @RequestParam(required = false) Integer workArea,
                                                     @RequestParam(required = false) String name,
                                                     @RequestParam(required = false) Integer power,
                                                     @RequestParam(required = false) Integer type
    ) {
        List<UserDao> userDaoList = userService.searchUser(id, skill, workArea, name, power, type);
        if (userDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(userDaoList);
        }
    }

}
