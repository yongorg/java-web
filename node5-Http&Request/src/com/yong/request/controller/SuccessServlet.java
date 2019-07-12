package com.yong.request.controller;

import com.yong.request.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //设置编码：
//        req.setCharacterEncoding("utf-8");

        // 设置响应编码
        resp.setContentType("text/html;character=utf-8");

        Student result =(Student)req.getAttribute("result");

        resp.getWriter().write("登录成功！" + result.getName() + "欢迎您@");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }
}
