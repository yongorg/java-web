package node.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.HttpJspPage;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 6. 案例：记住上一次访问时间
 * 1. 需求：
 * 1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 * <p>
 * 2. 分析：
 * 1. 可以采用Cookie来完成
 * 2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 * 1. 有：不是第一次访问
 * 1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 * 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 * 2. 没有：是第一次访问
 * 1. 响应数据：您好，欢迎您首次访问
 * 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */
@WebServlet("/cookieTest")
public class Demo05CookieTest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        // 1. 获取所有的cookie
        Cookie[] cookies = req.getCookies();
        // 2. 遍历cookie
        boolean result = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                // 4. 判断名称是否有lastTime
                if (name.equals("lastTime")) {
                    // 有 说明不是第一访问
                    String value = cookie.getValue();
                    resp.getWriter().write("<h1>欢迎回来，您上次访问时间为:"+ URLDecoder.decode(value, "UTF-8")+"</h1>");

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日--HH:mm:ss.SSS");
                    String lastTime = sdf.format(date);
                    String encode = URLEncoder.encode(lastTime, "UTF-8");

                    cookie.setValue(encode);
                    resp.addCookie(cookie);
                    result=true;
                    break;
                }
            }

        }
        if (cookies == null || cookies.length == 0 || result==false) {

            resp.getWriter().write("<h1>您好，欢迎您首次访问</h1>");

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日--HH:mm:ss.SSS");
            String lastTime = sdf.format(date);
            Cookie lastTimecookie = new Cookie("lastTime", URLEncoder.encode(lastTime, "UTF-8"));
            resp.addCookie(lastTimecookie);
            HttpJspPage jsp;
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
