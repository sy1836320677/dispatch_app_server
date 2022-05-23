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
    public int deleteWorkAreaById(Integer id) {
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
    public WorkAreaDao getWorkAreaById(Integer id) {
        return workAreaMapper.getWorkAreaById(id);
    }

    @Override
    public List<WorkAreaDao> searchWorkArea(Integer id, String name, String scope) {
        return workAreaMapper.searchWorkArea(id, name, scope);
    }

}
