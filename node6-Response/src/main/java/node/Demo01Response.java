package node;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向的特点:redirect
         1. 地址栏发生变化
         2. 重定向可以访问其他站点(服务器)的资源
         3. 重定向是两次请求。不能使用request对象来共享数据

 * 转发的特点：forward
         1. 转发地址栏路径不变
         2. 转发只能访问当前服务器下的资源
         3. 转发是一次请求，可以使用request对象来共享数据
 */
@WebServlet("/responseDemo1")
public class Demo01Response extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

//        //1. 设置状态码为302
//        resp.setStatus(302);
//        //2.设置响应头location
//        resp.setHeader("location","/day15/responseDemo2");

        System.out.println("我是---responseDemo1");

        //简单的重定向方法
        resp.sendRedirect("/node6/responseDemo2");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
