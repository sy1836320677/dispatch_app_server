package com.example.dispatch_app_server.controller;

import com.example.dispatch_app_server.annotation.UserLoginToken;
import com.example.dispatch_app_server.commons.web.ResponseResult;
import com.example.dispatch_app_server.dao.mysql.pojo.FacilityDao;
import com.example.dispatch_app_server.service.FacilityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private FacilityImpl facilityImpl;

    @PostMapping("/")
    @UserLoginToken
    public ResponseResult addFacility(HttpServletRequest httpServletRequest, @RequestBody FacilityDao facilityDao) {
        String token = httpServletRequest.getHeader("token");
        if(token == null) return ResponseResult.newFailResult("用户未登陆,请登录后重试");
        int res = facilityImpl.addFacility(facilityDao);
        if (res == 1) {
            return ResponseResult.newSuccessResult();
        } else {
            return ResponseResult.newFailResult();
        }
    }

    @DeleteMapping("/{id}")
    @UserLoginToken
    public ResponseResult deleteFacilityById(HttpServletRequest httpServletRequest, @PathVariable int id) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if(token==null){
            return ResponseResult.newFailResult("用户未登陆,请登录后重试");
        }
        int res = facilityImpl.deleteById(id);
        if (res == 1) {
            return ResponseResult.newSuccessResult();
        } else {
            return ResponseResult.newFailResult();
        }
    }

    @PutMapping("/")
    @UserLoginToken
    public ResponseResult updateFacilityById(HttpServletRequest httpServletRequest, @RequestBody FacilityDao facilityDao) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if(token==null){
            return ResponseResult.newFailResult("用户未登陆,请登录后重试");
        }
        int res = facilityImpl.updateById(facilityDao);
        if (res == 1) {
            return ResponseResult.newSuccessResult();
        } else {
            return ResponseResult.newFailResult();
        }
    }

    @GetMapping("/")
    public ResponseResult<List<FacilityDao>> getFacilityList() {
        List<FacilityDao> res = facilityImpl.getFacilityList();
        if (res.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(res);
        }
    }

    @GetMapping("/{id}")
    public ResponseResult<FacilityDao> getFacilityById(@PathVariable int id) {
        FacilityDao res = facilityImpl.getFacilityById(id);
        if (facilityImpl == null) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(res);
        }
    }

    @GetMapping("/skillRequirement")
    public ResponseResult<List<FacilityDao>> getFacilityBySkillReq(@RequestParam String skillRequirement) {
        List<FacilityDao> res = facilityImpl.getFacilityBySkillReq(skillRequirement);
        if (res.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(res);
        }
    }

}
