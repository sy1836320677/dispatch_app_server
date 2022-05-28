package com.example.dispatch_app_server.dao.mysql.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDao {
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", timezone = "GMT+8")
    private Date dueDate;
    private Integer process;
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Override
    public String toString() {
        return "Job" +
                "[id = " + id +
                ", name = " + name +
                ", dueDate = " + dueDate +
                ", process = " + process +
                ", createTime = " + createTime +
                ", upDateTime = " + updateTime +
                "]";
    }
}
