package com.yong.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 2.其他功能：
 *      1. 获取请求参数通用方式---见上demo5
 *
 *      2. 请求转发：一种在服务器内部的资源跳转方式
 * 				1. 步骤：
 * 					1. 通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
 * 					2. 使用RequestDispatcher对象来进行转发：forward(ServletRequest request, ServletResponse response)
 *
 * 				2. 特点：
 * 					1. 浏览器地址栏路径不发生变化
 * 					2. 只能转发到当前服务器内部资源中。
 * 					3. 转发是一次请求
         3. 共享数据：
 * 				* 域对象：一个有作用范围的对象，可以在范围内共享数据
 * 				* request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
 * 				* 方法：
 * 					1. void setAttribute(String name,Object obj):存储数据
 * 					2. Object getAttitude(String name):通过键获取值
 * 					3. void removeAttribute(String name):通过键移除键值对
 *
 *       4. 获取ServletContext：
 * 				* ServletContext getServletContext()
 * 			下次补充！
 */
@WebServlet("/Demo06Request")
public class Demo06Request extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo066666666666666666666Request被访问了！--------------------");


        // 1. 转发
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Demo07Request");
//        requestDispatcher.forward(req, resp);


        // 设置域对象
        req.setAttribute("msg", "woshiniba");

        // 获取ServletContext：
        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);

        // 转发
        req.getRequestDispatcher("/Demo07Request").forward(req, resp);



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
