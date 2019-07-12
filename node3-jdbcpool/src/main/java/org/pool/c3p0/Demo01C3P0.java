package org.pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *  c3p0步骤：
 * 			1. 导入jar包 (两个) c3p0-0.9.5.2.jar mchange-commons-java-0.2.12.jar ，
 * 				* 不要忘记导入数据库驱动jar包
 * 			2. 定义配置文件：
 * 				* 名称： c3p0.properties 或者 c3p0-config.xml
 * 				* 路径：直接将文件放在src目录下即可。
 *
 * 			3. 创建核心对象 数据库连接池对象 ComboPooledDataSource
 * 			4. 获取连接： getConnection
 */
public class Demo01C3P0 {


    public static void main(String[] args) throws SQLException {
        // 1. 创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();

        // 2. 获取连接对象
        Connection conn = ds.getConnection();

        // 3. 打印连接对象
        System.out.println(conn);
    }

}
