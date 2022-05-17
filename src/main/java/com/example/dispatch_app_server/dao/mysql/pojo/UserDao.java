package com.example.dispatch_app_server.dao.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDao {
    private int id;
    private String skill;
    private int workArea;
    private String name;
    private int power;
    private int type;
}
