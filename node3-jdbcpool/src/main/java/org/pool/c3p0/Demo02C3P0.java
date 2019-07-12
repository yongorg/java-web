package org.pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0获取10个连接对象
 */
public class Demo02C3P0 {
    public static void main(String[] args) throws SQLException {
        //使用默认的<default-config>配置方式
        //defaultConfig();

        //根据<named-config name="otherc3p0"> 选择配置方式
        nameConfig();

    }

    // 默认
    private static void defaultConfig() throws SQLException {
        // 1. 创建连接池对象
        DataSource ds = new ComboPooledDataSource();

        // 2. 获取10 个连接对象
        for (int i = 1; i <= 11; i++){
            Connection conn = ds.getConnection();
            System.out.println(conn);

            if (i == 5){
                conn.close(); // 归还连接到连接池中
            }
        }
    }

    // 根据config选择配置方式
    private static void nameConfig() throws SQLException {
        // 1. 创建连接池对象
        DataSource ds = new ComboPooledDataSource("otherc3p0");

        // 2. 获取10 个连接对象
        for (int i = 1; i <= 10; i++){
            Connection conn = ds.getConnection();
            System.out.println(conn);

            if (i == 5){
                conn.close(); // 归还连接到连接池中
            }
        }
    }
}
