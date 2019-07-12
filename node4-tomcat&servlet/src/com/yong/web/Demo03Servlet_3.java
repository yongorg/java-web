package com.yong.web;

import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet 3.0版本：
 *   好处：支持注解配置，可以不需要web.xml了
 *
 *   步骤：
 *          1.创建javaEE项目，选择Servlet的版本3.0版本以上，可以不创建web.xml
 *          2.定义类，实现Servlet接口
 *          3. 复写方法
 *          4. 在类上使用@WebServlet注解，进行配置
 *              @WebServlet("资源路径")
 *
 */
//@WebServlet(urlPatterns = "/demo3")
//@WebServlet(value = "/demo3")
@WebServlet("/demo3")
public class Demo03Servlet_3 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet 3.0 init............");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet 3.0 service............");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("servlet 3.0 destroy............");
    }
}
