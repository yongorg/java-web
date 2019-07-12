package com.yong.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * 2. 其他功能：
 * 			1. 获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数
 * 				1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
 * 				2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
 * 				3. Enumeration<String> getParameterNames():获取所有请求的参数名称
 * 				4. Map<String,String[]> getParameterMap():获取所有参数的map集合
 *
 * 				* 中文乱码问题：
 * 					* get方式：tomcat 8 已经将get方式乱码问题解决了
 * 					* post方式：会乱码
 * 						* 解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");
 *
 *
 * 			2. 请求转发：一种在服务器内部的资源跳转方式
 * 				1. 步骤：
 * 					1. 通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
 * 					2. 使用RequestDispatcher对象来进行转发：forward(ServletRequest request, ServletResponse response)
 *
 * 				2. 特点：
 * 					1. 浏览器地址栏路径不发生变化
 * 					2. 只能转发到当前服务器内部资源中。
 * 					3. 转发是一次请求
 *
 *
 * 			3. 共享数据：
 * 				* 域对象：一个有作用范围的对象，可以在范围内共享数据
 * 				* request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
 * 				* 方法：
 * 					1. void setAttribute(String name,Object obj):存储数据
 * 					2. Object getAttitude(String name):通过键获取值
 * 					3. void removeAttribute(String name):通过键移除键值对
 *
 * 			4. 获取ServletContext：
 * 				* ServletContext getServletContext()
 *
 * 			    --- 下次补充！
 *
 */
@WebServlet("/Demo05Request")
public class Demo05Request extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 注意： post需要设置字符编码解决中文乱码问题
        System.out.println("默认的字符编码：" + req.getCharacterEncoding());
        req.setCharacterEncoding("utf-8");
        System.out.println("设置后字符编码：" + req.getCharacterEncoding());

        System.out.println("dopost");

        // 1. 测试getParameter    根据参数名称获取参数值
        String username = req.getParameter("username");
        System.out.println("用户名：" + username);

        String passworld = req.getParameter("passworld");
        System.out.println("密码：" + passworld);

        String tel = req.getParameter("tel");
        System.out.println("手机号：" + tel);

        // 2. 测试 getParameterValues   根据参数名称获取参数值的数组
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        // 3. 测试 getParameterNames():获取所有请求的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){

            String name = parameterNames.nextElement();
            System.out.println(name);
            String parameter = req.getParameter(name);  // 有多个值默认获取第一个值
            System.out.println(parameter);
            System.out.println("----------------------------------------");

        }

        // 4. 测试 getParameterMap():获取所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap(); // 可以解决刚才的问题
        Set<String> names = parameterMap.keySet();
        for (String name : names) {

            System.out.println(name);

            String[] values = parameterMap.get(name);
            System.out.println(values);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("-------------------------------");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget");

        this.doPost(req,resp);

//        String username = req.getParameter("username");
//        System.out.println("用户名：" + username);
//
//        String passworld = req.getParameter("passworld");
//        System.out.println("密码：" + passworld);
//
//        String tel = req.getParameter("tel");
//        System.out.println("手机号：" + tel);

    }

}
