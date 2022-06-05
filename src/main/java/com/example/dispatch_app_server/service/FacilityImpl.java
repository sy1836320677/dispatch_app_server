package com.example.dispatch_app_server.service;

import com.example.dispatch_app_server.dao.mysql.mapper.FacilityMapper;
import com.example.dispatch_app_server.dao.mysql.pojo.FacilityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityImpl {
    @Autowired
    private FacilityMapper facilityMapper;

    public int addFacility(FacilityDao facilityDao) {
        return facilityMapper.addFacility(facilityDao);
    }


    public int deleteById(int id) {
        return facilityMapper.deleteFacility(id);
    }

    public int updateById(FacilityDao facilityDao) {
        return facilityMapper.updateFacilityById(facilityDao);
    }

    public List<FacilityDao> getFacilityList() {
        return facilityMapper.getFacilityList();
    }

    public FacilityDao getFacilityById(int id) {
        return facilityMapper.getFacilityById(id);
    }

    public List<FacilityDao> getFacilityBySkillReq(String skillRequirement) {
        return facilityMapper.getFacilityBySkillRequirement(skillRequirement);
    }

}
