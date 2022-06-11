package com.example.dispatch_app_server.controller;

import com.example.dispatch_app_server.annotation.UserLoginToken;
import com.example.dispatch_app_server.commons.web.ResponseResult;
import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;
import com.example.dispatch_app_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    @UserLoginToken
    public ResponseResult addUser(HttpServletRequest httpServletRequest, @RequestBody UserDao userDao) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if(token==null){
            return ResponseResult.newFailResult("用户未登陆,请登录后重试");
        }
        int res = userService.insertUser(userDao);
        if (res < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult();
        }
    }

    @DeleteMapping("/{id}")
    @UserLoginToken
    public ResponseResult deleteUserById(HttpServletRequest httpServletRequest, @PathVariable Integer id) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if(token==null){
            return ResponseResult.newFailResult("用户未登陆,请登录后重试");
        }
        int res = userService.deleteUserById(id);
        if (res < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult();
        }
    }

    @PutMapping("")
    @UserLoginToken
    public ResponseResult updateById(HttpServletRequest httpServletRequest, @RequestBody UserDao user) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if(token==null){
            return ResponseResult.newFailResult("用户未登陆,请登录后重试");
        }
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
                                                     @RequestParam(required = false) String name,
                                                     @RequestParam(required = false) Integer power,
                                                     @RequestParam(required = false) Integer type
    ) {
        List<UserDao> userDaoList = userService.searchUser(id, skill, name, power, type);
        if (userDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(userDaoList);
        }
    }

}
