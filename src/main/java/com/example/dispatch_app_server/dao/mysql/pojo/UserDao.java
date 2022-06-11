package com.example.dispatch_app_server.dao.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDao {
    private Integer id;
    private String skill;
    private String name;
    private Integer power;
    private Integer type;
    private Date createTime;
    private Date updateTime;
    @Override
    public String toString(){
        return "User" +
                "[id = "+ id +
                ", skill = "+ skill +
                ", name = " + name +
                ", power = " + power +
                ", type = " + type +
                ", createTime = " + createTime +
                ", upDateTime = " + updateTime +
                "]";
    }
}
