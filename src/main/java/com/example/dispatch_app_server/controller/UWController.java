package com.example.dispatch_app_server.controller;

import com.example.dispatch_app_server.annotation.UserLoginToken;
import com.example.dispatch_app_server.commons.web.ResponseResult;
import com.example.dispatch_app_server.dao.mysql.dto.UserWorkAreaDTO;
import com.example.dispatch_app_server.service.UserWorkAreaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
public class UWController {
    @Autowired
    private UserWorkAreaImpl userWorkAreaImpl;

    @GetMapping("/bindUserWithWorkArea")
    @UserLoginToken
    public ResponseResult bindUserWithWorkArea(HttpServletRequest httpServletRequest, @RequestParam int userId, @RequestParam int workAreaId) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if(token==null){
            return ResponseResult.newFailResult("用户未登陆,请登录后重试");
        }
        int res = userWorkAreaImpl.bindUserWithWorkArea(userId, workAreaId);
        if(res == 1) {
            return ResponseResult.newSuccessResult();
        } else {
            ResponseResult response = ResponseResult.newSuccessResult();
            response.setMsg("绑定失败：设备只能同时在一个工区");
            return response;
        }
    }

    @GetMapping("/unbindUserWithWorkArea")
    @UserLoginToken
    public ResponseResult unbindUserWithWorkArea(HttpServletRequest httpServletRequest, @RequestParam int userId, @RequestParam int workAreaId) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if(token==null){
            return ResponseResult.newFailResult("用户未登陆,请登录后重试");
        }
        int res = userWorkAreaImpl.unbindUserWithWorkArea(userId, workAreaId);
        if(res == 1) {
            return ResponseResult.newSuccessResult();
        } else {
            ResponseResult response = ResponseResult.newSuccessResult();
            response.setMsg("解除绑定失败：该设备还未绑定工区,请先绑定工区");
            return response;
        }
    }

    @GetMapping("/queryBindingByUserId/{id}")
    public ResponseResult<List<UserWorkAreaDTO>> getFWListByFacilityId(@PathVariable int id) {
        List<UserWorkAreaDTO> facilityWorkAreaDTOList = userWorkAreaImpl.getUWListByUserId(id);
        if (facilityWorkAreaDTOList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(facilityWorkAreaDTOList);
        }
    }

    @GetMapping("/queryBindingByWorkAreaId/{id}")
    public ResponseResult<List<UserWorkAreaDTO>> getFWListByWorkAreaId(@PathVariable int id) {
        List<UserWorkAreaDTO> facilityWorkAreaDTOList = userWorkAreaImpl.getUWListByWorkAreaId(id);
        if (facilityWorkAreaDTOList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(facilityWorkAreaDTOList);
        }
    }

    @GetMapping("/queryBinding")
    public ResponseResult<List<UserWorkAreaDTO>> getFWList() {
        List<UserWorkAreaDTO> facilityWorkAreaDTOList = userWorkAreaImpl.getUWList();
        if (facilityWorkAreaDTOList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(facilityWorkAreaDTOList);
        }
    }
}
