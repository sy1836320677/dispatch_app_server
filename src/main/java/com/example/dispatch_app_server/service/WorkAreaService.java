package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.pojo.WorkAreaDao;

import java.util.List;

public interface WorkAreaService {
    int insertWorkArea(WorkAreaDao workAreaDao);

    int deleteWorkAreaById(Integer id);

    int updateWorkAreaById(WorkAreaDao workAreaDao);

    List<WorkAreaDao> getAllWorkAreas();

    WorkAreaDao getWorkAreaById(Integer id);

    List<WorkAreaDao> searchWorkArea(Integer id, String name, String scope);
}
