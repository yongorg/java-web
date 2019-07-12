package org.pool.druid;

import org.utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 给 Student表添加一条数据
 */
public class Demo02DruidTestByUtils {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 获取连接对象
            conn = JDBCUtilsByDruid.getConnection();
            // 定义sql
            String sql = "insert into student values (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, null);
            stmt.setString(2, "muqiuyan");
            stmt.setString(3, "12354654");
            stmt.setString(4, "男");

            int i = stmt.executeUpdate();

            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtilsByDruid.close(stmt, conn, null);
        }



    }

}
