package org.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBCPUtils {
    private static DataSource ds;//定义一个连接池对象

    // 加载配置文件
    static {

        Properties pro = new Properties();
        InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
        try {
            pro.load(is);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("配置文件加载失败！");
        }

        try {
            ds = BasicDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 获取连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     *
     */
    public static void close(Statement stmt, Connection connection, ResultSet rs) {
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // 获取连接池对象
    public static DataSource getDataSources(){
        return ds;
    }
}
