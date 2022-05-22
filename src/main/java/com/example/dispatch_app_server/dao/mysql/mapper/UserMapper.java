package com.example.dispatch_app_server.dao.mysql.mapper;

import com.example.dispatch_app_server.dao.mysql.pojo.UserDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    String fieldListStr = "u_id AS id, u_skill AS skill, u_workarea AS workarea, u_name AS name, u_type AS type, u_power AS power, create_time AS createTime, update_time AS updateTime";

    @Insert("INSERT INTO user(u_id, u_skill, u_workarea, u_name, u_power, u_type) " +
            "VALUES(#{id}, #{skill}, #{workArea}, #{name}, #{power}, #{type})")
    int insertUser(UserDao userDao);

    @Select("SELECT " + fieldListStr + " FROM user")
    List<UserDao> getAllUsers();

    @Select("SELECT " + fieldListStr + " FROM user WHERE u_id = #{id}")
    UserDao getUserById(int id);

    @Select("SELECT " + fieldListStr + " FROM user WHERE u_skill like CONCAT('%',#{skill},'%')")
    List<UserDao> getUserBySkill(String skill);

    @Select("SELECT " + fieldListStr + " FROM user WHERE u_workarea = #{workArea}")
    List<UserDao> getUserByWorkArea(int workArea);

    @Select("SELECT " + fieldListStr + " FROM user WHERE u_type = #{type}")
    List<UserDao> getUserByType(int type);

    @Select("SELECT " + fieldListStr + " FROM user WHERE u_power = #{power}")
    List<UserDao> getUsersByPower(int power);

    @Update("UPDATE user SET u_skill = #{skill}, u_workarea = #{workArea}, u_name = #{name},u_power = #{power}, u_type = #{type} WHERE u_id = #{id}")
    int updateUserById(UserDao userDao);

}
