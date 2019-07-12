package anli.dao;


import anli.entity.Student;
import anli.utils.JDBCUtilsByDruid;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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
