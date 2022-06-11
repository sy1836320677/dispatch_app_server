package com.example.dispatch_app_server.dao.mysql.mapper;

import com.example.dispatch_app_server.dao.mysql.dto.FacilityWorkAreaDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FacilityWorkAreaMapper {
    @Insert("INSERT INTO facility_workarea(f_id, w_id) VALUES(#{facilityID}, #{workAreaID}) WHERE f_id NOT IN(SELECT f_id FROM facility_workarea)")
    public int bindFacilityToWorkArea(int facilityID, int workAreaID);

    @Delete("DELETE FROM facility_workarea WHERE f_id = #{facilityID} AND w_id = #{workAreaID}")
    public int unbindFacilityWithWorkArea(int facilityID, int workAreaID);

    @Select("SELECT facilityId, skillRequirement, maintainTime, longestWorkTime,type, workType, size, f.w_id AS workAreaId, w_name AS name, w_scope AS scope, x, y " +
            "FROM " +
            "(SELECT facility.f_id AS facilityId, f_skill_req AS skillRequirement, f_maintain_time AS maintainTime, f_longest_worktime AS longestWorkTime, f_type AS type, f_work_type AS workType, f_size AS size, w_id FROM facility JOIN facility_workarea ON facility.f_id = facility_workarea.f_id AND facility_workarea.w_id = #{id}) AS f JOIN workarea ON f.w_id = workarea.w_id")
    public List<FacilityWorkAreaDTO> getFWListByWorkAreaId(int id);

    @Select("SELECT facilityId, skillRequirement, maintainTime, longestWorkTime,type, workType, size, f.w_id AS workAreaId, w_name AS name, w_scope AS scope, x, y " +
            "FROM " +
            "(SELECT facility.f_id AS facilityId, f_skill_req AS skillRequirement, f_maintain_time AS maintainTime, f_longest_worktime AS longestWorkTime, f_type AS type, f_work_type AS workType, f_size AS size, w_id FROM facility JOIN facility_workarea ON facility.f_id = facility_workarea.f_id AND facility_workarea.f_id = #{id}) AS f JOIN workarea ON f.w_id = workarea.w_id")
    public List<FacilityWorkAreaDTO> getFWListByFacilityId(int id);

    @Select("SELECT facilityId, skillRequirement, maintainTime, longestWorkTime,type, workType, size, f.w_id AS workAreaId, w_name AS name, w_scope AS scope, x, y  " +
            "FROM " +
            "(SELECT facility.f_id AS facilityId, f_skill_req AS skillRequirement, f_maintain_time AS maintainTime, f_longest_worktime AS longestWorkTime, f_type AS type, f_work_type AS workType, f_size AS size, w_id FROM facility JOIN facility_workarea ON facility.f_id = facility_workarea.f_id) AS f JOIN workarea ON f.w_id = workarea.w_id")
    public List<FacilityWorkAreaDTO> getFWList();
}
