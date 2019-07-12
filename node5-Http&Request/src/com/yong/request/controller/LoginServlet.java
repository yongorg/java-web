package com.yong.request.controller;

import com.yong.request.dao.StudentDao;
import com.yong.request.entity.Student;

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
        Student student =new  Student();
        student.setName(name);
        student.setPassword(password);

        // 4. 调用StudentDao的login方法
        StudentDao studentDao = new StudentDao();
        Student resultStu = studentDao.login(student);

        // 5. 判断student
        if (resultStu == null) {

            // 登录失败！
            req.getRequestDispatcher("/failServlet");
        } else {

            // 登录成功！
            // 存储数据
            req.setAttribute("result", resultStu);

            // 转发
            req.getRequestDispatcher("/successServlet");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);

    }
}
