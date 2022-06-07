package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.dto.FacilityWorkAreaDTO;
import com.example.dispatch_app_server.dao.mysql.mapper.FacilityWorkAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityWorkAreaImpl {
    @Autowired
    private FacilityWorkAreaMapper facilityWorkAreaMapperMapper;

    public int bindFacilityWithWorkArea(int facilityId, int workAreaId) {
        int size = facilityWorkAreaMapperMapper.getFWListByFacilityId(facilityId).size();
        if (size == 0) {
            return facilityWorkAreaMapperMapper.bindFacilityToWorkArea(facilityId, workAreaId);
        } else {
            // 已经绑定过，不能重复绑定工区
            return 0;
        }
    }

    public int unbindFacilityWithWorkArea(int facilityId, int workAreaId) {
        int size = facilityWorkAreaMapperMapper.getFWListByFacilityId(facilityId).size();
        if (size == 1) {
            return facilityWorkAreaMapperMapper.unbindFacilityWithWorkArea(facilityId, workAreaId);
        } else {
            // 没有绑定过，不能删除不存在的绑定关系
            return 0;
        }
    }

    public List<FacilityWorkAreaDTO> getFWListByFacilityId(int facilityId) {
        return facilityWorkAreaMapperMapper.getFWListByFacilityId(facilityId);
    }

    public List<FacilityWorkAreaDTO> getFWListByWorkAreaId(int workAreaId) {
        return facilityWorkAreaMapperMapper.getFWListByWorkAreaId(workAreaId);
    }

    public List<FacilityWorkAreaDTO> getFWList() {
        return facilityWorkAreaMapperMapper.getFWList();
    }
}
