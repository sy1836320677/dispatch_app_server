package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.dto.UserWorkAreaDTO;
import com.example.dispatch_app_server.dao.mysql.mapper.UserWorkAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWorkAreaImpl {
    @Autowired
    private UserWorkAreaMapper userWorkAreaMapper;

    public int bindUserWithWorkArea(int userId, int workAreaId) {
        int size = userWorkAreaMapper.getUWListByUserId(userId).size();
        if (size == 0) {
            return userWorkAreaMapper.bindUserToWorkArea(userId, workAreaId);
        } else {
            // 已经绑定过，不能重复绑定工区
            return 0;
        }
    }

    public int unbindUserWithWorkArea(int userId, int workAreaId) {
        int size = userWorkAreaMapper.getUWListByUserId(userId).size();
        if (size == 1) {
            return userWorkAreaMapper.unbindUserWithWorkArea(userId, workAreaId);
        } else {
            // 没有绑定过，不能删除不存在的绑定关系
            return 0;
        }
    }

    public List<UserWorkAreaDTO> getUWListByUserId(int userId) {
        return userWorkAreaMapper.getUWListByUserId(userId);
    }

    public List<UserWorkAreaDTO> getUWListByWorkAreaId(int workAreaId) {
        return userWorkAreaMapper.getUWListByWorkAreaId(workAreaId);
    }

    public List<UserWorkAreaDTO> getUWList() {
        return userWorkAreaMapper.getUWList();
    }
}
