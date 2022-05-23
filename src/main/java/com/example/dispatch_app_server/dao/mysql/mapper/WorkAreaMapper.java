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
    int deleteWorkAreaById(Integer id);

    @Update("UPDATE workarea SET w_name = #{name}, w_scope = #{scope} WHERE w_id = #{id}")
    int updateWorkAreaById(WorkAreaDao workAreaDao);

    @Select("SELECT " + fieldListStr + " FROM workarea")
    List<WorkAreaDao> getAllWorkAreas();

    @Select("SELECT " + fieldListStr + " FROM workarea WHERE w_id = #{id}")
    WorkAreaDao getWorkAreaById(Integer id);

    @Select({
            "<script>",
            "SELECT",
            fieldListStr,
            "FROM workarea",
            "WHERE 1 = 1",
            "<if test = 'id != null'>",
            "AND w_id = #{id}",
            "</if>",
            "<if test = 'name != null'>",
            "AND w_name LIKE CONCAT('%', #{name}, '%')",
            "</if>",
            "<if test = 'scope != null'>",
            "AND w_scope LIKE CONCAT('%', #{scope}, '%')",
            "</if>",
            "</script>"
    })
    List<WorkAreaDao> searchWorkArea(Integer id, String name, String scope);
}
