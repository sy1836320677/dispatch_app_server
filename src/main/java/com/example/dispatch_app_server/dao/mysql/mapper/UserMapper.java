package com.example.dispatch_app_server.dao.mysql.mapper;

import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    String fieldListStr = "u_id AS id, u_skill AS skill, u_workarea AS workArea, u_name AS name, u_type AS type, u_power AS power, create_time AS createTime, update_time AS updateTime";

    @Insert("INSERT INTO user(u_id, u_skill, u_workarea, u_name, u_power, u_type) " +
            "VALUES(#{id}, #{skill}, #{workArea}, #{name}, #{power}, #{type})")
    int insertUser(UserDao userDao);

    @Delete("DELETE FROM user WHERE u_id = #{id}")
    int deleteUserById(int id);

    @Update("UPDATE user SET u_skill = #{skill}, u_workarea = #{workArea}, u_name = #{name},u_power = #{power}, u_type = #{type} WHERE u_id = #{id}")
    int updateUserById(UserDao userDao);

    @Select("SELECT " + fieldListStr + " FROM user")
    List<UserDao> getAllUsers();

    @Select({
            "<script>",
            "SELECT",
            fieldListStr,
            "FROM user",
            "WHERE 1 = 1",
            "<if test = 'id != null'>",
            "AND u_id = #{id}",
            "</if>",
            "<if test = 'skill != null'>",
            "AND u_skill LIKE CONCAT('%', #{skill}, '%')",
            "</if>",
            "<if test = 'workArea != null'>",
            "AND u_workarea LIKE CONCAT('%', #{workArea}, '%')",
            "</if>",
            "<if test = 'name != null'>",
            "AND u_name LIKE CONCAT('%', #{name}, '%')",
            "</if>",
            "<if test = 'power != null'>",
            "AND u_power = #{power}",
            "</if>",
            "<if test = 'type != null'>",
            "AND u_type = #{type}",
            "</if>",
            "</script>"
    })
    public List<UserDao> searchUser(Integer id, String skill, Integer workArea, String name, Integer power, Integer type);

}
