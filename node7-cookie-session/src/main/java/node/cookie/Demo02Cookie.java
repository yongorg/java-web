package node.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/demo2")
public class Demo02Cookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 3. 获取cookie
        Cookie[] cookies = req.getCookies();
        System.out.println(cookies);
        System.out.println("-------------");
        if (cookies != null) {

            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();

                System.out.println(URLDecoder.decode(value, "UTF-8"));
                System.out.println(name + "--" + value);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }
}
