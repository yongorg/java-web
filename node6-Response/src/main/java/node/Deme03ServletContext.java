package node;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

/**
 * ServletContext:
 * <p>
 * 1. 概念：代表整个web应用，可以和程序的容器(服务器)来通信
 * <p>
 * 2. 获取：
 * 1. 通过request对象获取
 * request.getServletContext();
 * 2. 通过HttpServlet获取
 * this.getServletContext();
 * 3. 功能：
 * 1. 获取MIME类型：
 * * MIME类型:在互联网通信过程中定义的一种文件数据类型
 * * 格式： 大类型/小类型   text/html		image/jpeg
 * <p>
 * * 获取：String getMimeType(String file)
 * 2. 域对象：共享数据
 * 1. setAttribute(String name,Object value)
 * 2. getAttribute(String name)
 * 3. removeAttribute(String name)
 * <p>
 * * ServletContext对象范围：所有用户所有请求的数据
 * 3. 获取文件的真实(服务器)路径
 * 1. 方法：String getRealPath(String path)
 * String b = context.getRealPath("/b.txt");//web目录下资源访问
 * System.out.println(b);
 * <p>
 * String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
 * System.out.println(c);
 * <p>
 * String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
 * System.out.println(a);
 */
@WebServlet("/demo3")
public class Deme03ServletContext extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 1. 获取ServletContext对象：它代表整个web应用
        ServletContext servletContext1 = req.getServletContext(); // 通过request方式获取
        ServletContext servletContext2 = this.getServletContext(); // 通过HttpServlet获取
        System.out.println(servletContext1 + "---------" + servletContext2);

        // 2. 获取MIME类型：
        //          在互联网通信过程中定义的一种文件类型
        //              如：text/html  ; image/jpeg
        String mimeType = servletContext1.getMimeType("s.png");
        System.out.println(mimeType);


        // 3. 域对象：共享数据
        // 3.1 设置数据
        servletContext1.setAttribute("msg", "haha数据共享了！");

        // 4. 获取文件的服务器路径
        String realPath = servletContext1.getRealPath("/index.jsp");        // web目录下面的资源路径
        System.out.println(realPath);

        String realPath1 = servletContext1.getRealPath("/WEB-INF/web.xml"); // WEB-INF目录下面的资源访问
        System.out.println(realPath1);

        String realPath2 = servletContext1.getRealPath("/WEB-INF/classes/a.txt"); //src目录下的资源访问（maven项目对应resources）
        URL resource = Deme03ServletContext.class.getClassLoader().getResource("a.txt");//src目录下的资源访问（maven项目对应resources）
        System.out.println(realPath2);
        System.out.println(resource.getPath());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }
}
