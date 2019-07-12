package cn.node;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc 使用步骤
 */
public class Demo01JDBC {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

        //3. 定义sql
        String sql = "update student set name = '倪杰' where id = 1 ";

        //4. 获取执行对象
        Statement stmt = conn.createStatement();

        //5. 执行sql
        int i = stmt.executeUpdate(sql);

        //6. 处理
        System.out.println(i);

        //7. 释放资源
        stmt.close();
        conn.close();

    }


}
