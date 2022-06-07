package com.example.dispatch_app_server.controller;

import com.example.dispatch_app_server.commons.web.ResponseResult;
import com.example.dispatch_app_server.dao.mysql.pojo.FacilityDao;
import com.example.dispatch_app_server.service.FacilityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private FacilityImpl facilityImpl;

    @PostMapping("/")
    public ResponseResult addFacility(@RequestBody FacilityDao facilityDao) {
        int res = facilityImpl.addFacility(facilityDao);
        if (res == 1) {
            return ResponseResult.newSuccessResult();
        } else {
            return ResponseResult.newFailResult();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteFacilityById(@PathVariable int id) {
        int res = facilityImpl.deleteById(id);
        if (res == 1) {
            return ResponseResult.newSuccessResult();
        } else {
            return ResponseResult.newFailResult();
        }
    }

    @PutMapping("/")
    public ResponseResult updateFacilityById(@RequestBody FacilityDao facilityDao) {
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
