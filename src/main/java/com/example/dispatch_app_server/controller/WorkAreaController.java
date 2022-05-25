package com.example.dispatch_app_server.controller;

import com.example.dispatch_app_server.commons.web.ResponseResult;
import com.example.dispatch_app_server.dao.mysql.pojo.WorkAreaDao;
import com.example.dispatch_app_server.service.WorkAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
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
    public ResponseResult deleteById(@PathVariable Integer id) {
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


    @GetMapping("/search")
    public ResponseResult<List<WorkAreaDao>> searchWorkArea(@RequestParam(required = false) Integer id, @RequestParam(required = false) String name, @RequestParam(required = false) String scope) {
        List<WorkAreaDao> workAreaDaoList = workAreaService.searchWorkArea(id, name, scope);
        if(workAreaDaoList.size() != 0) {
            return ResponseResult.newSuccessResult(workAreaDaoList);
        } else {
            return ResponseResult.newFailResult();
        }
    }
}
