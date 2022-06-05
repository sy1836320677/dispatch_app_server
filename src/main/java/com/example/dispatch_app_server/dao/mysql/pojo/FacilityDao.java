package com.example.dispatch_app_server.dao.mysql.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDao {
    private Integer id;
    private String skillRequirement;
    private Integer maintainTime;
    private Integer longestWorkTime;
    private Integer type;
    private Integer workType;
    private Integer size;
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
