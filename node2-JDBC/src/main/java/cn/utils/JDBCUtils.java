package cn.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String url;
    private static String username;
    private static String password;
    private static String driver;


    /**
     * 通过静态代码块获取配置文件数据
     */
    static {
        try {
            // 1. 获取配置文件
            Properties pro = new Properties();

            // 2. 加载配置文件
            // pro.load(new FileReader("src/jdbc.properties"));

            // 2.1 通过类加载器获取配置文件路径
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();

            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            System.out.println(path);
            //2.2 加载配置文件
            pro.load(new FileReader(path));

            //3. 获取数据
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            url  = pro.getProperty("url");
            driver = pro.getProperty("driver");


            // 4. 加载驱动
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;

    }




    /**
     * 释放资源
     */
    public static void close( Statement stmt,Connection conn){
        try {
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt, Connection conn, ResultSet rs){
        try {
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 执行sql
     */
    public static void executeUpdate(String sql) throws SQLException {

        Connection conn = JDBCUtils.getConnection();

        Statement statement = conn.createStatement();

        int i = statement.executeUpdate(sql);

        System.out.println(i);

        JDBCUtils.close(statement, conn);

    }

}
