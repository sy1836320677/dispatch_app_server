package com.example.dispatch_app_server.dao.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WorkAreaDao {
    private Integer id;
    private String name;
    private String scope;
    private Date createTime;
    private Date updateTime;
    private Float x;
    private Float y;
}
