package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.mapper.WorkAreaMapper;
import com.example.dispatch_app_server.dao.mysql.pojo.WorkAreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkAreaImpl implements WorkAreaService {
    @Autowired
    private WorkAreaMapper workAreaMapper;

    @Override
    public int insertWorkArea(WorkAreaDao workAreaDao) {
        return workAreaMapper.insertWorkArea(workAreaDao);
    }

    @Override
    public int deleteWorkAreaById(int id) {
        return workAreaMapper.deleteWorkAreaById(id);
    }

    @Override
    public int updateWorkAreaById(WorkAreaDao workAreaDao) {
        return workAreaMapper.updateWorkAreaById(workAreaDao);
    }

    @Override
    public List<WorkAreaDao> getAllWorkAreas() {
        return workAreaMapper.getAllWorkAreas();
    }

    @Override
    public WorkAreaDao getWorkAreaById(int id) {
        return workAreaMapper.getWorkAreaById(id);
    }

    @Override
    public List<WorkAreaDao> getWorkAreaByName(String name) {
        return workAreaMapper.getWorkAreaByName(name);
    }

    @Override
    public List<WorkAreaDao> getWorkAreaByScope(String scope) {
        return workAreaMapper.getWorkAreaByScope(scope);
    }


}
