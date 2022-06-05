package com.example.dispatch_app_server.dao.mysql.mapper;

import com.example.dispatch_app_server.dao.mysql.pojo.FacilityDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FacilityMapper {
    String tbFields = "f_id, f_skill_req, f_maintain_time, f_longest_worktime, f_type, f_work_type, f_size";
    String daoFields = "#{id}, #{skillRequirement}, #{maintainTime}, #{longestWorkTime}, #{type}, #{workType}, #{size}, #{createTime}, #{updateTime}";

    @Insert("INSERT INTO facility(" +
            tbFields +
            ") " +
            "" +
            "VALUES(" + daoFields + ")")
    public int addFacility(FacilityDao facilityDao);

    @Delete("DELETE FROM facility WHERE f_id = #{id}")
    public int deleteFacility(int id);

    @Update("UPDATE facility SET f_skill_req = #{skillRequirement}, f_maintain_time = #{maintainTime}, f_longest_worktime = #{longestWorkTime}, f_type = #{type}, #{f_work_type} = #{workType}, f_size = #{size} WHERE f_id = #{id}")
    public int updateFacilityById(FacilityDao facilityDao);

    @Select("SELECT f_id AS id, f_skill_req AS skillRequirement, f_maintain_time AS maintainTime, f_longest_worktime AS longestWorkTime, f_type AS type, f_work_type AS workType, f_size AS size, create_time AS createTime, update_time AS update_time FROM facility")
    public List<FacilityDao> getFacilityList();

    @Select("SELECT f_id AS id, f_skill_req AS skillRequirement, f_maintain_time AS maintainTime, f_longest_worktime AS longestWorkTime, f_type AS type, f_work_type AS workType, f_size AS size, create_time AS createTime, update_time AS update_time FROM facility WHERE f_id = #{id}")
    public FacilityDao getFacilityById(int id);

    @Select("SELECT f_id AS id, f_skill_req AS skillRequirement, f_maintain_time AS maintainTime, f_longest_worktime AS longestWorkTime, f_type AS type, f_work_type AS workType, f_size AS size, create_time AS createTime, update_time AS update_time FROM facility WHERE f_skill_req LIKE CONCAT('%', #{skillRequirement}, '%')")
    public List<FacilityDao> getFacilityBySkillRequirement(String skillRequirement);
}
