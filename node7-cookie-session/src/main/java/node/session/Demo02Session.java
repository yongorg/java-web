package node.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Demo02Session")
public class Demo02Session extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用Session获取数据
        resp.setContentType("text/html;charset=utf-8");
        // 1. 获取session
        HttpSession session = req.getSession();
        // 2. 存储数据
        String msg = (String) session.getAttribute("msg");
        System.out.println(msg);
        resp.getWriter().write(msg);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
