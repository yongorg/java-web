package com.yong.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 2. 获取请求头数据
 * * 方法：
 * * (*)String getHeader(String name):通过请求头的名称获取请求头的值
 * * Enumeration<String> getHeaderNames():获取所有的请求头名称
 */
@WebServlet("/Demo02Request")
public class Demo02Request extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 演示获取请求头信息

        // 1. 获取所有请求头数据

        Enumeration<String> headerNames = req.getHeaderNames();

        // 2. 遍历
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();

            // 根据名称获取请求头的值
            String value = req.getHeader(name);

            System.out.println(name + "::" + value);
        }

    }
}
