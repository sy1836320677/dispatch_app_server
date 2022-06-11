package com.example.dispatch_app_server.dao.mysql.mapper;

import com.example.dispatch_app_server.dao.mysql.pojo.LoginRegisterPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginRegisterMapper {
    LoginRegisterPojo findByUsername(String username);

    LoginRegisterPojo findUserById(String id);
}
