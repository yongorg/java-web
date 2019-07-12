package dao;


import entity.Student;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtilsByDruid;

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
