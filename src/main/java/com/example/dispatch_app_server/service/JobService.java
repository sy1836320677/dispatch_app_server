package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.pojo.JobDao;

import java.util.Date;
import java.util.List;

public interface JobService {
    public int addJob(JobDao jobDao);

    public int deleteJobById(Integer id);

    public int updateJobById(JobDao jobDao);

    public List<JobDao> getJobList();

    public JobDao getJobById(Integer id);

    public List<JobDao> searchJobs(Integer id, String name);

    public List<JobDao> getJoBListLTDate(Date date);

    public List<JobDao> getJoBListETDate(Date date);

    public List<JobDao> getJoBListLTProcess(Integer process);

    public List<JobDao> getJoBListMTProcess(Integer process);
}
