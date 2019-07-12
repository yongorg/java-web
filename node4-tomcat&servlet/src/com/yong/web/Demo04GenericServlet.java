package com.yong.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet体系结构：
 *
 *              Servlet -- 接口
 *                 |
 *             GenericServlet -- 抽象类
 *                 |
 *             HttpServlet  -- 抽象类
 *
 *     GenericServlet: 将Servlet接口中其他方法做了默认实现，只有service（）方法作为抽象。
 *              * 将来定义Servlet类时，可以继承GenericServlet，实现service即可！(真正开发用它还是比较少)
 *
 *    HttpServlet： 对HTTP协议的一种封装，简化操作
 *          1. 定义类继承HttpServlet
 *          2. 复写doGet()或者doPost方法
 *
 *
 */
@WebServlet("/demo4")
public class Demo04GenericServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo4......................GenericServlet");
    }
}
