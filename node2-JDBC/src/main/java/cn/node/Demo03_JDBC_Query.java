package cn.node;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo03_JDBC_Query {

    private static final String URL = "jdbc:mysql:///test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {

        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.创建连接对象
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        //3.拼写sql语句
        String sql = "select * from student";

        //4.创建statement对象7
        Statement st = con.createStatement();

        //5.执行sql语句，返回结果集
        ResultSet rs = st.executeQuery(sql);

        //6.遍历结果集
        while (rs.next()) {
            String username =  rs.getString("name");
            String password = (String) rs.getObject("password");
            String gender = (String) rs.getObject("gender");
            System.out.println(username+":"+password+":"+gender);
        }

        //7.关闭资源
        rs.close();
        st.close();
        con.close();

    }

}

