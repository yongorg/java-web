package com.yong.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 7. Servlet相关配置
 *             1. urlpartten:Servlet访问路径
 *                 1. 一个Servlet可以定义多个访问路径 ： @WebServlet({"/d4","/dd4","/ddd4"})
 *                 2. 路径定义规则：
 *                     1. /xxx：路径匹配
 *                     2. /xxx/xxx:多层路径，目录结构
 *                     3. *.do：扩展名匹配
 */
//@WebServlet({"/dome4","/dd4","/ddd4"})    //配置多个映射
//@WebServlet("/dd/aa") //多层路径，目录结构
//@WebServlet("/*") // 代表所有
//@WebServlet("*.do")
public class Demo05ServletConfig extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doget!...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println("dopost");
    }
}
