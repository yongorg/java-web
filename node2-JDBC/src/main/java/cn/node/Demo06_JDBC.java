package cn.node;

import cn.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 控制事务
 *  模拟转账
 *
 */
public class Demo06_JDBC {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            // 1. 获取连接
            conn = JDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            // 2. 定义sql
            //  倪杰给lyy转账500块钱！
            String sql1 = "update account set balance = balance - ? where username = ?";
            String sql2 = "update account set balance = balance + ? where username = ?";

            // 获取执行对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);

            // 设置参数
            pstmt1.setDouble(1, 500);
            pstmt1.setString(2, "nijie");

            pstmt2.setDouble(1, 500);
            pstmt2.setString(2, "lyy");
            int i = pstmt1.executeUpdate();
            int x = i / 0;  // 手动制造异常
            int j = pstmt2.executeUpdate();
            System.out.println(i);
            System.out.println(j);

            //提交事务
            conn.commit();

        } catch (Exception e) {

            // 回滚
            try {
                if (conn!= null){
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt1, conn);
            JDBCUtils.close(pstmt2, conn);
        }
    }
}
