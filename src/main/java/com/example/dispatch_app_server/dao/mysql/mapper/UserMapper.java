package com.example.dispatch_app_server.dao.mysql.mapper;

import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(u_id, u_skill, u_workarea, u_name, u_power, u_type) " +
            "VALUES(#{id}, #{skill}, #{workArea}, #{name}, #{power}, #{type})")
    int insert(UserDao userDao);
}
