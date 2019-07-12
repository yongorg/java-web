package org.DBUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.utils.JDBCUtilsByDruid;

import java.sql.SQLException;

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
public class Demo02DBUtils {

    public static final QueryRunner QUERYRUNNER = new QueryRunner(JDBCUtilsByDruid.getDataSources());

    /**
     * @version 1.0
     * @throws Exception
     * 修改id为1号数据的 name 为 wohenshuai
     */
    @Test
    public void test1Update() throws Exception {
        String sql = "update student set name = ? where id = ?";

        int count = QUERYRUNNER.update(sql, new Object[]{"wohenshuai", 1});

        System.out.println(count);
    }


    /*
    添加一条记录
     */
    @Test
    public void test2Insert() throws SQLException {
        String sql = "insert into student values(?,?,?,?,?,?,?)";

        int count = QUERYRUNNER.update(sql, null, "mqy", "1234256", "女",18000,18,null);

        System.out.println(count);
    }

    /*
    删除刚才添加的记录
     */
    @Test
    public void test3Delete() throws SQLException {
        String sql = "delete from student where name = ?";

        int count = QUERYRUNNER.update(sql, "mqy");

        System.out.println(count);
    }




    @Test//6-1. 查询所有记录，将其封装为Student对象的List集合
    public void test6Query() {


    }
    @Test//6-2. 查询所有记录，将其封装为Student对象的List集合
    public void test6_2Query() {

    }

    /**
     *     7. 查询总记录数
     *     queryForObject：一般执行一些聚合函数
     */
    @Test
    public void test7queryForObject() {

    }
}
