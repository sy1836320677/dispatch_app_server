package com.example.dispatch_app_server.dao.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserWorkAreaDTO {
    private Integer userId;
    private String userSkill;
    private String userName;
    private Integer userPower;
    private Integer userType;
    private Integer workAreaId;
    private String workAreaName;
    private String workAreaScope;
    private Float x;
    private Float y;
}
