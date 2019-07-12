package org.DBUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.utils.JDBCUtilsByDruid;

import java.sql.SQLException;

/**
 *
     使用dbutils完成curd操作

     dbutils：
     是apache组织的一个工具类，jdbc的框架，封装了jdbc；
         使用步骤：
             1.导入jar包
             commons-dbutils-1.6.jar
             2.创建一个queryrunner类
             queryrunner作用：操作sql语句
             构造方法：new QueryRunner(DataSource ds);
             3.编写sql语句
             4.执行sql
             query(...)：执行查询操作
             update(...)：执行增删改操作

         核心类或接口
             QueryRunner：类
                作用：操作sql语句
             构造器：
                    new QueryRunner(DataSource ds);
                    注意：底层帮我们创建了语句执行者，帮我们释放资源
             常用方法：
                    query();
                    update();

     DbUtils：释放资源，控制事务 类
            closeQuietly(conn)：内部处理了异常
            commitAndClose(Connection conn)：提交事务并释放连接
             ....

     ResultSetHandler：封装结果集 接口
         9个实现类

            ArrayHandler		将查询结果的第一条记录封装成数组
            ArrayListHandler	将查询结果的每一条记录封装成数组，将每一个数组放入list中
            ★★BeanHandler		将查询结果的第一条记录封装成指定的bean对象
            ★★BeanListHandler	将查询结果的每一条记录封装成指定的bean对象，将每一个bean对象放入list中
            ColumnListHandler	将查询结果的指定一列放在list
            KeyedHandler
            MapHandler			将查询结果的第一条记录封装成map，字段名为key，值为value
            ★MapListHandler		将查询结果的每一条记录封装成map，将每一个map放入list
            ★ScalarHandler		针对于聚合函数 例如：count() 返回的是一个long值
 *
 * @author  yongz
 * @date 2019年5月14日
 */
public class Demo01DButils {
    public static void main(String[] args) throws SQLException {
        // 1. 导入jar包//导入依赖
        // 2. new queryrunner类
        QueryRunner qr = new QueryRunner(JDBCUtilsByDruid.getDataSources());
        // 3. 编写sql语句
        String sql = "update student set name = 'sbsbsb' where id = ?";
        // 4. 执行sql
        int count = qr.update(sql, new Object[]{1});

        System.out.println(count);
    }


}
