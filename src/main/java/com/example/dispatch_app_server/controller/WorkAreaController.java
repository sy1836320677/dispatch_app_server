package com.example.dispatch_app_server.controller;

import com.example.dispatch_app_server.commons.web.ResponseResult;
import com.example.dispatch_app_server.dao.mysql.pojo.WorkAreaDao;
import com.example.dispatch_app_server.service.WorkAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workArea")
public class WorkAreaController {
    @Autowired
    private WorkAreaService workAreaService;

    @PostMapping("")
    public ResponseResult addWorkArea(@RequestBody WorkAreaDao workAreaDao) {
        int res = workAreaService.insertWorkArea(workAreaDao);
        if(res < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteById(@PathVariable int id) {
        int res = workAreaService.deleteWorkAreaById(id);
        if(res < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult();
        }
    }

    @PutMapping("")
    public ResponseResult updateById(@RequestBody WorkAreaDao workAreaDao) {
        int res = workAreaService.updateWorkAreaById(workAreaDao);
        if(res < 1) {
            return ResponseResult.newFailResult();
        } else {
            return ResponseResult.newSuccessResult();
        }
    }

    @GetMapping("")
    public ResponseResult<List<WorkAreaDao>> getWorkAreaList() {
        List<WorkAreaDao> list = workAreaService.getAllWorkAreas();
        if(workAreaService != null) {
            return ResponseResult.newSuccessResult(list);
        } else {
            return ResponseResult.newFailResult();
        }
    }

    @GetMapping("/{id}")
    public ResponseResult<WorkAreaDao> getWorkAreaById(@PathVariable int id) {
        WorkAreaDao workAreaDao = workAreaService.getWorkAreaById(id);
        if(workAreaDao != null) {
            return ResponseResult.newSuccessResult(workAreaDao);
        } else {
            return ResponseResult.newFailResult();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseResult<List<WorkAreaDao>> getWorkAreasByName(@PathVariable String name) {
        List<WorkAreaDao> workAreaDao = workAreaService.getWorkAreaByName(name);
        if(workAreaDao != null) {
            return ResponseResult.newSuccessResult(workAreaDao);
        } else {
            return ResponseResult.newFailResult();
        }
    }
    @GetMapping("/scope/{scope}")
    public ResponseResult<List<WorkAreaDao>> getWorkAreasByScope(@PathVariable String scope) {
        List<WorkAreaDao> workAreaDao = workAreaService.getWorkAreaByScope(scope);
        if(workAreaDao != null) {
            return ResponseResult.newSuccessResult(workAreaDao);
        } else {
            return ResponseResult.newFailResult();
        }
    }

}
