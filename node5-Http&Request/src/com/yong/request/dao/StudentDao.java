package com.yong.request.dao;

import com.alibaba.druid.sql.visitor.functions.If;
import com.yong.request.entity.Student;
import com.yong.request.utils.JDBCUtilsByDruid;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDao {

    private static JdbcTemplate temp = new JdbcTemplate(JDBCUtilsByDruid.getDataSources());

    /**
     * 登录方法
     * @param loginStu
     * @return
     */
    public Student login(Student loginStu){
        String sql  = "select * from student where name = ? and password = ?";
        Student student = null;
        try {
            student = temp.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class),loginStu.getName(),loginStu.getPassword());
            return student;
        }catch (EmptyResultDataAccessException e){
            return  null;
        }

    }

}
