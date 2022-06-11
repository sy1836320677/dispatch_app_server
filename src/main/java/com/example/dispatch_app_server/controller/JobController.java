package com.example.dispatch_app_server.controller;

import com.example.dispatch_app_server.annotation.UserLoginToken;
import com.example.dispatch_app_server.commons.web.ResponseResult;
import com.example.dispatch_app_server.dao.mysql.dto.JobDTO;
import com.example.dispatch_app_server.dao.mysql.pojo.JobDao;
import com.example.dispatch_app_server.service.JobService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("/")
    @UserLoginToken
    public ResponseResult addJob(HttpServletRequest httpServletRequest, @RequestBody JobDTO jobDTO) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if(token==null){
            return ResponseResult.newFailResult("无token,用户未登陆");
        }
        JobDao jobDao=JobDao.transJobDtoToPojo(jobDTO);
        int res = jobService.addJob(jobDao);
        if (res == 1) {
            return ResponseResult.newSuccessResult(jobService.getJobById(jobDao.getId()));
        } else {
            return ResponseResult.newFailResult();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteById(@PathVariable Integer id) {
        int res = jobService.deleteJobById(id);
        if (res != 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult();
        }
    }

    @PutMapping("/")
    public ResponseResult updateById(@RequestBody JobDao jobDao) {
        int res = jobService.updateJobById(jobDao);
        if (res != 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult();
        }
    }

    @GetMapping("/")
    public ResponseResult<List<JobDao>> getAllJobs() {
        List<JobDao> res = jobService.getJobList();
        if (res.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(res);
        }
    }

    @GetMapping("/search")
    public ResponseResult<List<JobDao>> searchJobList(@RequestParam(required = false) Integer id,
                                                      @RequestParam(required = false) String name) {
        List<JobDao> jobDaoList = jobService.searchJobs(id, name);
        if (jobDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(jobDaoList);
        }
    }

    @GetMapping("/afterDate")
    public ResponseResult<List<JobDao>> afterDate(@RequestParam Date date) {
        List<JobDao> jobDaoList = jobService.getJoBListLTDate(date);
        if (jobDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(jobDaoList);
        }
    }

    @GetMapping("/beforeDate")
    public ResponseResult<List<JobDao>> beforeDate(@RequestParam Date date) {
        List<JobDao> jobDaoList = jobService.getJoBListETDate(date);
        if (jobDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(jobDaoList);
        }
    }

    @GetMapping("/moreThanProcess")
    public ResponseResult<List<JobDao>> moreThanProcess(@RequestParam Integer process) {
        List<JobDao> jobDaoList = jobService.getJoBListMTProcess(process);
        if (jobDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(jobDaoList);
        }
    }

    @GetMapping("/lessThanProcess")
    public ResponseResult<List<JobDao>> lessThanProcess(@RequestParam Integer process) {
        List<JobDao> jobDaoList = jobService.getJoBListLTProcess(process);
        if (jobDaoList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(jobDaoList);
        }
    }


}
