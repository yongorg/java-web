package com.yong.tools;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource ds;


    // 加载配置文件并获取连接池对象
    static {
        Properties pro = new Properties();
        try {
            // 加载配置文件
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("dbcp.properties"));
            // 创建连接池对象
            ds = BasicDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

    // 释放资源
    public static void  close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (connection != null){
            connection.close();
        }
        if (statement != null){
            statement.close();
        }
        if (resultSet != null){
            resultSet.close();
        }
    }
    public static void  close(Connection connection, Statement statement) throws SQLException {
        if (connection != null){connection.close();  }
        if (statement != null){statement.close();}
    }
}
