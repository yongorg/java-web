package node;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/demo4")
public class Deme04ServletContext extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 1. 获取ServletContext对象：它代表整个web应用
        ServletContext servletContext1 = req.getServletContext(); // 通过request方式获取

        // 3.1 获取ServletContext对象共享数据
        Object msg = servletContext1.getAttribute("msg");
        System.out.println(msg);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }
}
