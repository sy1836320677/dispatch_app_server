package com.example.dispatch_app_server.dao.mysql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkAreaDao {
    private Integer id;
    private String name;
    private String scope;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "WorkArea" +
                "[id = " + id +
                ", name = " + name +
                ", scope = " + scope +
                ", createTime = " + createTime +
                ", upDateTime = " + updateTime +
                "]";
    }
}
