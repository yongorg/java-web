package anli.servlet;

import anli.dao.StudentDao;
import anli.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        req.getSession().removeAttribute("fc");
//        System.out.println(username+password+checkCode);
        String cc_session = (String) req.getSession().getAttribute("cc_session");
        System.out.println(cc_session);
        boolean b = checkCode.equalsIgnoreCase(cc_session);
        System.out.println(b);
        if(checkCode != null && checkCode.equalsIgnoreCase(cc_session)){
            // 检查username与password
            Student login = new StudentDao().login(Student.builder().name(username).password(password).build());
            if (login != null){
                resp.sendRedirect("./success.jsp");
                req.getSession().setAttribute("stu", login);
            }else {
                resp.sendRedirect("./login.jsp");
                req.getSession().setAttribute("fc", "密码错误！");
            }


        }else {
            // 告诉前端验证码输入错误！
            resp.sendRedirect("./login.jsp");
            req.getSession().setAttribute("fc", "验证码错误！");
            System.out.println("验证码有误！");

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
