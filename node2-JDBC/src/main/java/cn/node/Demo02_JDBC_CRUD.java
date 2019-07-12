package cn.node;

import cn.utils.JDBCUtils;
import org.junit.Test;

import java.sql.SQLException;

/**
 * 给student表，添加一条数据，CRUD
 */
public class Demo02_JDBC_CRUD {


    /**
     * DDL 语句
     */
    @Test
    public void test1() throws SQLException {
        String sql = "insert into student values(null,'zhuhao',123456,'男')";
        JDBCUtils.executeUpdate(sql);
    }
    @Test
    public void test2() throws SQLException {
        String sql = "update student set password = 999999 where id = 3";
        JDBCUtils.executeUpdate(sql);
    }
    @Test
    public void test3() throws SQLException {
        String sql = "delete from student where id = 6";
        JDBCUtils.executeUpdate(sql);
    }
    @Test
    public void test4() throws SQLException {
        String sql = "create table if not exists stu (id int, name varchar(20))";
        JDBCUtils.executeUpdate(sql);
    }

}
