package com.example.dispatch_app_server.controller;

import com.example.dispatch_app_server.annotation.UserLoginToken;
import com.example.dispatch_app_server.commons.web.ResponseResult;
import com.example.dispatch_app_server.dao.mysql.dto.FacilityWorkAreaDTO;
import com.example.dispatch_app_server.service.FacilityWorkAreaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
public class FWController {
    @Autowired
    private FacilityWorkAreaImpl facilityWorkAreaImpl;

    @GetMapping("/bindFacilityWithWorkArea")
    @UserLoginToken
    public ResponseResult bindFacilityWithWorkArea(HttpServletRequest httpServletRequest, @RequestParam int facilityId, @RequestParam int workAreaId) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if(token==null){
            return ResponseResult.newFailResult("用户未登陆,请登录后重试");
        }
        int res = facilityWorkAreaImpl.bindFacilityWithWorkArea(facilityId, workAreaId);
        if(res == 1) {
            return ResponseResult.newSuccessResult();
        } else {
            ResponseResult response = ResponseResult.newSuccessResult();
            response.setMsg("绑定失败：设备只能同时在一个工区");
            return response;
        }
    }

    @GetMapping("/unbindFacilityWithWorkArea")
    @UserLoginToken
    public ResponseResult unbindFacilityWithWorkArea(HttpServletRequest httpServletRequest, @RequestParam int facilityId, @RequestParam int workAreaId) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if(token==null){
            return ResponseResult.newFailResult("用户未登陆,请登录后重试");
        }
        int res = facilityWorkAreaImpl.unbindFacilityWithWorkArea(facilityId, workAreaId);
        if(res == 1) {
            return ResponseResult.newSuccessResult();
        } else {
            ResponseResult response = ResponseResult.newSuccessResult();
            response.setMsg("解除绑定失败：该设备还未绑定工区,请先绑定工区");
            return response;
        }
    }

    @GetMapping("/queryFWBindingByFacilityId/{id}")
    public ResponseResult<List<FacilityWorkAreaDTO>> getFWListByFacilityId(@PathVariable int id) {
        List<FacilityWorkAreaDTO> facilityWorkAreaDTOList = facilityWorkAreaImpl.getFWListByFacilityId(id);
        if (facilityWorkAreaDTOList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(facilityWorkAreaDTOList);
        }
    }

    @GetMapping("/queryFWBindingByWorkAreaId/{id}")
    public ResponseResult<List<FacilityWorkAreaDTO>> getFWListByWorkAreaId(@PathVariable int id) {
        List<FacilityWorkAreaDTO> facilityWorkAreaDTOList = facilityWorkAreaImpl.getFWListByWorkAreaId(id);
        if (facilityWorkAreaDTOList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(facilityWorkAreaDTOList);
        }
    }

    @GetMapping("/queryFWBinding")
    public ResponseResult<List<FacilityWorkAreaDTO>> getFWList() {
        List<FacilityWorkAreaDTO> facilityWorkAreaDTOList = facilityWorkAreaImpl.getFWList();
        if (facilityWorkAreaDTOList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(facilityWorkAreaDTOList);
        }
    }
}
