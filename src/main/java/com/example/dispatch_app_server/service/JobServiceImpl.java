package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.mapper.JobMapper;
import com.example.dispatch_app_server.dao.mysql.pojo.JobDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;


    @Override
    public int addJob(JobDao jobDao) {
        return jobMapper.addJob(jobDao);
    }

    @Override
    public int deleteJobById(Integer id) {
        return jobMapper.deleteById(id);
    }

    @Override
    public int updateJobById(JobDao jobDao) {
        return jobMapper.updateById(jobDao);
    }

    @Override
    public JobDao getJobById(Integer id) {
        return jobMapper.getJobById(id);
    }

    @Override
    public List<JobDao> getJobList() {
        return jobMapper.getJobList();
    }

    @Override
    public List<JobDao> searchJobs(Integer id, String name) {
        return jobMapper.searchJobs(id, name);
    }

    @Override
    public List<JobDao> getJoBListLTDate(Date date) {
        return jobMapper.jobListLTDate(date);
    }

    @Override
    public List<JobDao> getJoBListETDate(Date date) {
        return jobMapper.jobListETDate(date);
    }

    @Override
    public List<JobDao> getJoBListLTProcess(Integer process) {
        return jobMapper.jobListLTProcess(process);
    }

    @Override
    public List<JobDao> getJoBListMTProcess(Integer process) {
        return jobMapper.jobListMTProcess(process);
    }


}
