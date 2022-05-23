package com.example.dispatch_app_server.dao.mysql.mapper;

import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;
import com.example.dispatch_app_server.dao.mysql.pojo.WorkAreaDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorkAreaMapper {
    String fieldListStr = "w_id AS id, w_name AS name, w_scope AS scope, create_time AS createTime, update_time AS updateTime";

    @Insert("INSERT INTO workarea(w_id, w_name, w_scope) " +
            "VALUES(#{id}, #{name}, #{scope})")
    int insertWorkArea(WorkAreaDao workAreaDao);

    @Delete("DELETE FROM workarea WHERE w_id = #{id}")
    int deleteWorkAreaById(int id);

    @Update("UPDATE workarea SET w_name = #{name}, w_scope = #{scope} WHERE w_id = #{id}")
    int updateWorkAreaById(WorkAreaDao workAreaDao);

    @Select("SELECT " + fieldListStr + " FROM workarea")
    List<WorkAreaDao> getAllWorkAreas();

    @Select("SELECT " + fieldListStr + " FROM workarea WHERE w_id = #{id}")
    WorkAreaDao getWorkAreaById(int id);

    @Select("SELECT " + fieldListStr + " FROM workarea WHERE w_name like CONCAT('%',#{name},'%')")
    List<WorkAreaDao> getWorkAreaByName(String name);

    @Select("SELECT " + fieldListStr + " FROM workarea WHERE w_scope LIKE CONCAT('%', #{scope}, '%')")
    List<WorkAreaDao> getWorkAreaByScope(String workArea);

}
