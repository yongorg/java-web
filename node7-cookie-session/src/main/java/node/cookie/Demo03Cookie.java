package node.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * java.lang.IllegalArgumentException: Control character in cookie value or attribute.
 * cookie中文会报这个异常
 */

/**
 * 3. 实现原理
 * 		* 基于响应头set-cookie和请求头cookie实现
 *
 * 	4. cookie的细节
 * 		1. 一次可不可以发送多个cookie?
 * 			* 可以创建多个Cookie对象，使用response调用多次addCookie方法发送cookie即可。
 *
 * 		2. cookie在浏览器中保存多长时间？
 * 			1. 默认情况下，当浏览器关闭后，Cookie数据被销毁
 * 			2. 持久化存储：
 * 				* setMaxAge(int seconds)
 * 					1. 正数：将Cookie数据写到硬盘的文件中。持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效
 * 					2. 负数：默认值
 * 					3. 零：删除cookie信息
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
@WebServlet("/demo3")
public class Demo03Cookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie c1 = new Cookie("msg1", "+:cijiuhua");
        Cookie c2 = new Cookie("msg2", "-:default");
        Cookie c3 = new Cookie("msg3", "0:delete");
        // 设置cookie存活时间
        c1.setMaxAge(30); // 持久化 3000秒
        c2.setMaxAge(-1); // 默认值
        c3.setMaxAge(0); // 删除


        resp.addCookie(c1);
        resp.addCookie(c2);
        resp.addCookie(c3);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
