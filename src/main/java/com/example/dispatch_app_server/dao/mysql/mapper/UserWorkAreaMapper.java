package com.example.dispatch_app_server.dao.mysql.mapper;

import com.example.dispatch_app_server.dao.mysql.dto.FacilityWorkAreaDTO;
import com.example.dispatch_app_server.dao.mysql.dto.UserWorkAreaDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserWorkAreaMapper {
    @Insert("INSERT INTO user_workarea(u_id, w_id) VALUES(#{userId}, #{workAreaId}) WHERE f_id NOT IN(SELECT u_id FROM user_workarea)")
    public int bindUserToWorkArea(int userId, int workAreaId);

    @Delete("DELETE FROM user_workarea WHERE u_id = #{userID} AND w_id = #{workAreaId}")
    public int unbindUserWithWorkArea(int userId, int workAreaId);

    @Select("SELECT userId, userSkill, userName, userPower, userType, w_name AS workAreaName, uw.w_id AS workAreaId, w_name AS workAreaName, w_scope AS workAreaScope, x, y " +
            "FROM " +
            "(SELECT user.u_id AS userID, u_skill AS userSkill, u_name AS userName, u_power AS userPower, u_type AS userType, w_id FROM user JOIN user_workarea ON user.u_id = user_workarea.u_id AND user_workarea.w_id = #{workAreaId}) AS uw JOIN workarea ON uw.w_id = workarea.w_id")
    public List<UserWorkAreaDTO> getUWListByWorkAreaId(int workAreaId);

    @Select("SELECT userId, userSkill, userName, userPower, userType, w_name AS workAreaName, uw.w_id AS workAreaId, w_name AS workAreaName, w_scope AS workAreaScope, x, y " +
            "FROM " +
            "(SELECT user.u_id AS userId, u_skill AS userSkill, u_name AS userName, u_power AS userPower, u_type AS userType, w_id FROM user JOIN user_workarea ON user.u_id = user_workarea.u_id AND u_id = #{userId}) AS uw JOIN workarea ON uw.w_id = workarea.w_id")
    public List<UserWorkAreaDTO> getUWListByUserId(int workAreaId);

    @Select("SELECT userId, userSkill, userName, userPower, userType, w_name AS workAreaName, uw.w_id AS workAreaId, w_name AS workAreaName, w_scope AS workAreaScope, x, y " +
            "FROM " +
            "(SELECT user.u_id AS userId, u_skill AS userSkill, u_name AS userName, u_power AS userPower, u_type AS userType, w_id FROM user JOIN user_workarea ON user.u_id = user_workarea.u_id) AS uw JOIN workarea ON uw.w_id = workarea.w_id")
    public List<UserWorkAreaDTO> getUWList();
}
