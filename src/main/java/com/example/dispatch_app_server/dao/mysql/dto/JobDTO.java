package com.example.dispatch_app_server.dao.mysql.dto;

import com.example.dispatch_app_server.dao.mysql.pojo.JobNeedFacilityPojo;
import com.example.dispatch_app_server.dao.mysql.pojo.JobNeedPeoplePojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", timezone = "GMT+8")
    private Date dueDate;
    private Integer process;
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", timezone = "GMT+8")
    private List<JobNeedPeoplePojo> NeedPeopleList;
    private List<JobNeedFacilityPojo> NeedFacilityList;
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
