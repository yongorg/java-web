package controller;

import dao.StudentDao;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("sdsa");
        // 1. 设置编码格式
        req.setCharacterEncoding("utf-8");

        // 2. 获取请求参数
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        // 3. 封装Student参数
        Student student = Student.builder().name(name).password(password).build();
        System.out.println(student);

        // 4. 调用StudentDao的login方法
        StudentDao studentDao = new StudentDao();
        Student resultStu = studentDao.login(student);

        System.out.println(resultStu);

        // 5. 判断student
        if (resultStu == null){

            // 登录失败！
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        }else {

            // 登录成功！
            // 存储数据
            req.setAttribute("result", resultStu );

            // 转发
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);

    }
}
