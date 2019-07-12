package com.yong.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 2. 执行原理：
 * 		1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
 * 		2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
 * 		3. 如果有，则在找到对应的<servlet-class>全类名
 * 		4. tomcat会将字节码文件加载进内存，并且创建其对象
 * 		5. 调用其方法
 *
 */
public class Demo01Servlet implements javax.servlet.Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /*
         *  2. 执行原理：
         *   		1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
         *   		2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
         *   		3. 如果有，则在找到对应的<servlet-class>全类名
         *  		4. tomcat会将字节码文件加载进内存，并且创建其对象
         *   		5. 调用其方法
         */
        System.out.println("hello servlet！");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
