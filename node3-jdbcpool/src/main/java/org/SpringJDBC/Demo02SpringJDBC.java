package org.SpringJDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.entity.Student;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.utils.DBCPUtils;
import org.utils.JDBCUtilsByDruid;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 需求：
 * 				1. 修改id为1号数据的 name 为 倪杰
 * 				2. 添加一条记录
 * 				3. 删除刚才添加的记录
 * 				4. 查询id为1的记录，将其封装为Map集合
 * 			            注意：查询结果只能为1
 * 				5. 查询所有记录，将其封装为List
 * 			            注意；将每一条数据封装成map存入list
 * 				6. 查询所有记录，将其封装为Emp对象的List集合
 * 				7. 查询总记录数
 */
public class Demo02SpringJDBC {

    /**
     * @version 1.0
     * @throws Exception
     * 修改id为1号数据的 name 为 倪杰
     */
    @Test
    public void test1Update() throws Exception {
        //1. 创建JdbcTemplate
//        Properties pro = new Properties();
//        InputStream is = Demo02SpringJDBC.class.getClassLoader().getResourceAsStream("druid.properties");
//        pro.load(is);
//        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        JdbcTemplate temp = new JdbcTemplate(DBCPUtils.getDataSources());

        String sql = "update student set name = ? where id = ?";

        int count = temp.update(sql, "倪杰", 1);

        System.out.println(count);

    }


    /*
    添加一条记录
     */
    @Test
    public void test2Insert() {

        JdbcTemplate temp = new JdbcTemplate(JDBCUtilsByDruid.getDataSources());

        String sql = "insert into student values(?,?,?,?,?,?,?)";

        int count = temp.update(sql, null, "mqy", "1234256", "女",18000,18,null);

        System.out.println(count);
    }

    /*
    删除刚才添加的记录
     */
    @Test
    public void test3Delete() {

        JdbcTemplate temp = new JdbcTemplate(JDBCUtilsByDruid.getDataSources());

        String sql = "delete from student where name = ?";

        int count = temp.update(sql, "mqy");

        System.out.println(count);
    }

    /**
     * 查询id为1的记录，将其封装为Map集合
     * 注意：查询的结果集只能是1个
     */
    @Test
    public void test4QueryForMap() {

        JdbcTemplate temp = new JdbcTemplate(JDBCUtilsByDruid.getDataSources());

        String sql = "select * from student where name = ?";

        Map<String, Object> students = temp.queryForMap(sql, "nijiesb");

        System.out.println(students);

        Set<String> studentsKey = students.keySet();

        // 遍历获取所有字段名和值
        for (String s : studentsKey) {
            System.out.println(s+":"+students.get(s));
        }


        System.out.println();

    }

    @Test//查询所有记录，将其封装为List
    public void test5queryForList() {

        JdbcTemplate temp = new JdbcTemplate(JDBCUtilsByDruid.getDataSources());

        String sql = "select  * from student";

        List<Map<String, Object>> maps = temp. queryForList(sql);

        System.out.println(maps);

        // 遍历集合
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }


    }

    @Test//6-1. 查询所有记录，将其封装为Student对象的List集合
    public void test6Query() {

        JdbcTemplate temp = new JdbcTemplate(JDBCUtilsByDruid.getDataSources());

        String sql = "select * from student";

        List<Student> students = temp.query(sql, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {

                Student student = Student.builder().
                           id(resultSet.getLong(1)).
                        name(resultSet.getString(2)).
                        password(resultSet.getString(3)).
                        gender(resultSet.getString(4)).
                        balance(resultSet.getDouble(5)).
                        age(resultSet.getInt(6)).
                        insertTime(resultSet.getDate(7)).build();
                return student;
            }
        });

        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test//6-2. 查询所有记录，将其封装为Student对象的List集合
    public void test6_2Query() {

        JdbcTemplate temp = new JdbcTemplate(JDBCUtilsByDruid.getDataSources());

        String sql = "select * from student";
        Student stu = new Student();
        List<Student> students = temp.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     *     7. 查询总记录数
     *     queryForObject：一般执行一些聚合函数
     */
    @Test
    public void test7queryForObject() {
        JdbcTemplate temp = new JdbcTemplate(JDBCUtilsByDruid.getDataSources());
        
        String sql ="select count(*) from student";

        String total = temp.queryForObject(sql, String.class);

        System.out.println(total);
    }
}
