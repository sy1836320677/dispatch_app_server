package com.example.dispatch_app_server.controller;

import com.example.dispatch_app_server.commons.web.ResponseResult;
import com.example.dispatch_app_server.dao.mysql.dto.FacilityWorkAreaDTO;
import com.example.dispatch_app_server.service.FacilityWorkAreaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FWController {
    @Autowired
    private FacilityWorkAreaImpl facilityWorkAreaImpl;

    @GetMapping("/bindFacilityWithWorkArea")
    public ResponseResult bindFacilityWithWorkArea(@RequestParam int facilityId, @RequestParam int workAreaId) {
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
    public ResponseResult unbindFacilityWithWorkArea(@RequestParam int facilityId, @RequestParam int workAreaId) {
        int res = facilityWorkAreaImpl.unbindFacilityWithWorkArea(facilityId, workAreaId);
        if(res == 1) {
            return ResponseResult.newSuccessResult();
        } else {
            ResponseResult response = ResponseResult.newSuccessResult();
            response.setMsg("解除绑定失败：该设备还未绑定工区");
            return response;
        }
    }

    @GetMapping("/queryBindingByFacilityId/{id}")
    public ResponseResult<List<FacilityWorkAreaDTO>> getFWListByFacilityId(@PathVariable int id) {
        List<FacilityWorkAreaDTO> facilityWorkAreaDTOList = facilityWorkAreaImpl.getFWListByFacilityId(id);
        if (facilityWorkAreaDTOList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(facilityWorkAreaDTOList);
        }
    }

    @GetMapping("/queryBindingByWorkAreaId/{id}")
    public ResponseResult<List<FacilityWorkAreaDTO>> getFWListByWorkAreaId(@PathVariable int id) {
        List<FacilityWorkAreaDTO> facilityWorkAreaDTOList = facilityWorkAreaImpl.getFWListByWorkAreaId(id);
        if (facilityWorkAreaDTOList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(facilityWorkAreaDTOList);
        }
    }

    @GetMapping("/queryBinding")
    public ResponseResult<List<FacilityWorkAreaDTO>> getFWList() {
        List<FacilityWorkAreaDTO> facilityWorkAreaDTOList = facilityWorkAreaImpl.getFWList();
        if (facilityWorkAreaDTOList.size() < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult(facilityWorkAreaDTOList);
        }
    }
}
