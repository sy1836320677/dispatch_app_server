package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.pojo.WorkAreaDao;

import java.util.List;

public interface WorkAreaService {
    int insertWorkArea(WorkAreaDao workAreaDao);

    int deleteWorkAreaById(int id);

    List<WorkAreaDao> getAllWorkAreas();

    WorkAreaDao getWorkAreaById(int id);

    List<WorkAreaDao> getWorkAreaByName(String name);

    List<WorkAreaDao> getWorkAreaByScope(String scope);

    int updateWorkAreaById(WorkAreaDao workAreaDao);
}
