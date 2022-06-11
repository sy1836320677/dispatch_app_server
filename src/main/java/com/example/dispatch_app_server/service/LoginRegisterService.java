package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.mapper.LoginRegisterMapper;
import com.example.dispatch_app_server.dao.mysql.pojo.LoginRegisterPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginRegisterService {
    @Autowired
    private LoginRegisterMapper loginRegisterMapper;
    public LoginRegisterPojo findByUsername(LoginRegisterPojo user){
        return loginRegisterMapper.findByUsername(user.getUsername());
    }
    public LoginRegisterPojo findUserById(String userId) {
        return loginRegisterMapper.findUserById(userId);
    }
}
