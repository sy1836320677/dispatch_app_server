package com.example.dispatch_app_server.dao.mysql.mapper;

import com.example.dispatch_app_server.dao.mysql.pojo.JobDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface JobMapper {
    String sql = " j_id AS id, j_name AS name, j_due_date As dueDate, j_process AS process, create_time AS createTime, update_time AS updateTime, need_people, need_facility ";


    @Insert("INSERT INTO job(j_name, j_due_date, j_process, need_people, need_facility) " +
            "VALUES(#{name}, #{dueDate}, #{process}, #{need_people}, #{need_facility})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="j_id")
    public int addJob(JobDao jobDao);

    @Delete("DELETE FROM job WHERE j_id = #{id}")
    public int deleteById(Integer id);

    @Update("UPDATE job SET j_name = #{name}, j_due_date = #{dueDate}, j_process = #{process} WHERE j_id = #{id}")
    public int updateById(JobDao jobDao);

    @Select("SELECT" +
            sql + "FROM job")
    public List<JobDao> getJobList();

    @Select("SELECT" +
            sql + "FROM job WHERE j_id = #{id}")
    public JobDao getJobById(Integer id);

    @Select({
            "<script>",
            "SELECT",
            sql,
            "FROM job",
            "WHERE 1 = 1",
            "<if test = 'id != null'>",
            "AND j_id = #{id}",
            "</if>",
            "<if test = 'name != null'>",
            "AND j_name LIKE CONCAT('%', #{name}, '%')",
            "</if>",
            "</script>"
    }
    )
    public List<JobDao> searchJobs(Integer id, String name);

    /*
     * 查找晚于目标日期的作业列表
     * @param dueDate 目标日期
     * */
    @Select("SELECT" +
            sql +
            "FROM job WHERE j_due_date >= #{Date}")
    public List<JobDao> jobListLTDate(Date Date);

    /*
     * 查找早于目标日期的作业列表
     * @param dueDate 目标日期
     * */
    @Select("SELECT" +
            sql +
            "FROM job WHERE j_due_date <= #{Date}")
    public List<JobDao> jobListETDate(Date Date);

    /*
     * 查找作业进度大于等于目标值的作业列表
     * @param process 作业进度目标值
     * */
    @Select("SELECT" + sql +
            "FROM job WHERE j_process >= #{process}")
    public List<JobDao> jobListMTProcess(Integer process);

    /*
     * 查找作业进度小于等于目标值的作业列表
     * @param process 作业进度目标值
     * */
    @Select("SELECT" + sql +
            "FROM job WHERE j_process <= #{process}")
    public List<JobDao> jobListLTProcess(Integer process);


}
