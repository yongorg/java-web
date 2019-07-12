package anli.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsByDruid {

    private static DataSource ds;

    /**
     * 加载配置文件 ，初始化对象
     */
    static {
        // 加载配置文件
        Properties pro = new Properties();
        InputStream is = JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            // 获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接对象
     * @return
     */
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
    public static void close(Statement stmt, Connection connection) throws SQLException {
        close(stmt, connection, null);
    }

    /**
     * 获取连接池的方法
     *
     * @return
     */
    public  static DataSource getDataSources(){
        return ds;
    }
}
