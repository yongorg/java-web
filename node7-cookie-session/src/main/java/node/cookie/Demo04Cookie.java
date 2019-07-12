package node.cookie;

import javax.lang.model.element.VariableElement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
/**
 * java.lang.IllegalArgumentException: Control character in cookie value or attribute.
 * cookie中文会报这个异常
 */

/**
 * 
 * 		3. cookie能不能存中文？
 * 			* 在tomcat 8 之前 cookie中不能直接存储中文数据。
 * 				* 需要将中文数据转码---一般采用URL编码(%E3)
 * 			* 在tomcat 8 之后，cookie支持中文数据。特殊字符还是不支持，建议使用URL编码存储，URL解码解析
 * 		4. cookie共享问题？
 * 			1. 假设在一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？
 * 				* 默认情况下cookie不能共享
 *
 * 				* setPath(String path):设置cookie的获取范围。默认情况下，设置当前的虚拟目录
 * 					* 如果要共享，则可以将path设置为"/"
 *
 *
 * 			2. 不同的tomcat服务器间cookie共享问题？
 * 				* setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享
 * 					* setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中cookie可以共享
 *
 */
@WebServlet("/demo4")
public class Demo04Cookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 创建 Cookie
//        Cookie cookie = new Cookie("demo4msg", "你好");

        String str = "你好！";


         System.out.println(URLEncoder.encode(str, "UTF-8"));
        System.out.println(URLDecoder.decode(str, "UTF-8"));

        Cookie cookie = new Cookie("demo4msg", URLEncoder.encode(str, "UTF-8"));

        resp.addCookie(cookie);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
