package com.example.dispatch_app_server.dao.mysql.pojo;

import com.example.dispatch_app_server.dao.mysql.dto.JobDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    private String need_people;
    private String need_facility;
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

    public static JobDao transJobDtoToPojo(JobDTO jobDTO){
        JobDao jobDao=new JobDao();
        jobDao.setName(jobDTO.getName());
        jobDao.setProcess(jobDTO.getProcess());
        jobDao.setDueDate(jobDTO.getDueDate());
        List<JobNeedPeoplePojo> needPeopleList = jobDTO.getNeedPeopleList();
        StringBuffer sf1=new StringBuffer();
        int flag1=0;
        for(JobNeedPeoplePojo pojo:needPeopleList){
            sf1.append(pojo.getType()+":"+pojo.getNumber());
            flag1++;
            if(flag1!=needPeopleList.size()){
                sf1.append(",");
            }
        }
        jobDao.setNeed_people(sf1.toString());

        List<JobNeedFacilityPojo> needFacilityList = jobDTO.getNeedFacilityList();
        StringBuffer sf2=new StringBuffer();
        int flag2=0;
        for(JobNeedFacilityPojo pojo:needFacilityList){
            sf2.append(pojo.getType()+":"+pojo.getNumber());
            flag2++;
            if(flag2!=needPeopleList.size()){
                sf2.append(",");
            }
        }
        jobDao.setNeed_facility(sf2.toString());
        return jobDao;
    }
}
