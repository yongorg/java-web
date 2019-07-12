package org.pool.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 1. 步骤：
 * 			1. 导入jar包 druid-1.0.9.jar
 * 			2. 定义配置文件：
 * 				* 是properties形式的
 * 				* 可以叫任意名称，可以放在任意目录下
 * 			3. 加载配置文件。Properties
 * 			4. 获取数据库连接池对象：通过工厂来来获取  DruidDataSourceFactory
 * 			5. 获取连接：getConnection
 */
public class Demo01Druid {

    @Test
    public void testDruid() throws Exception {
        // 0. 加载配置文件
        Properties pro = new Properties();
        InputStream is = Demo01Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);

        // 1. 获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        // 2. 获取连接对象
        Connection conn = ds.getConnection();

        System.out.println(conn);

        // 3. 归还连接对象
        conn.close();
    }


}
