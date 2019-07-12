package com.yong.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 获取请求行数据
 *
 *      * GET /day14/demo1?name=zhangsan HTTP/1.1
 *
 *      * 方法：
 *          1. 获取请求方式 ：GET
 *              * String getMethod()
 *          2. (*)获取虚拟目录：/day14
 *               * String getContextPath()
 *          3. 获取Servlet路径: /demo1
 *               * String getServletPath()
 *          4. 获取get方式请求参数：name=zhangsan
 *              * String getQueryString()
 *          5. (*)获取请求URI：/day14/demo1
 *              * String getRequestURI():		/day14/demo1
 *              * StringBuffer getRequestURL()  :http://localhost/day14/demo1
 *
 *                      * URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
 *                      * URI：统一资源标识符 : /day14/demo1					共和国
 *
 *          6. 获取协议及版本：HTTP/1.1
 *              * String getProtocol()
 *
 *          7. 获取客户机的IP地址：
 *              * String getRemoteAddr()
 */
@WebServlet("/demo6")
public class Demo01Request extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget");

        String method = req.getMethod(); //获取请求方式    :  GET
        System.out.println("请求方式:"+ method);

        String contextPath = req.getContextPath(); // 获取虚拟目录 : /node4
        System.out.println("虚拟目录："+ contextPath);

        String servletPath = req.getServletPath();  // 获取Servlet路径 : /demo6
        System.out.println("Servlet路径:" + servletPath);

        String queryString = req.getQueryString(); //获取get方式请求参数 : null
        System.out.println("get方式请求参数:" + queryString );

        String requestURI = req.getRequestURI();  // 获取请求URI:   *URI：统一资源标识符 : /node4/demo6
        StringBuffer requestURL = req.getRequestURL(); // 获取请求路径RUL : * URL:统一资源定位符 ： http://localhost/node4/demo6
        System.out.println("请求URI:"+ requestURI +"\n"+"请求路径RUL:"+requestURL);

        String protocol = req.getProtocol(); // 获取协议及版本 : HTTP/1.1
        System.out.println("协议及版本:" + protocol);

        String remoteAddr = req.getRemoteAddr();//获取客户机的IP地址：127.0.0.1
        System.out.println("客户机的IP地址：" + remoteAddr);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println("dopost");
    }
}
