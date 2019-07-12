package cn.node;

import cn.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/** statement这样会存在Bug
  * 当密码输入：a'or'a'='a
  */
public class Demo05Login {


    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username =  sc.next();


        System.out.println("请输入密码:");
        String password =  sc.next();


        Demo05Login login = new Demo05Login();
        boolean result = login.Login(username, password);

        if (result){
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败！");
        }


    }

    public boolean Login(String username,String password)  {
        // 1. 获取连接对象
        Connection conn = JDBCUtils.getConnection();

        // 2. 执行sql对象
        PreparedStatement pstm = null;
        String sql = null;  // sql
        ResultSet rs = null;   // 结果集
        try {
            sql = "select name,password from student where name = ? and password =?";
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1,username);
            pstm.setString(2,password);


            System.out.println(sql);
            rs = pstm.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstm, conn,rs);
        }

        return false;

    }


}
