package anli.filedownload;

import anli.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1. 获取请求参数，文件名称
        String filename = req.getParameter("filename");

        System.out.println(filename);


        // 2. 使用字节流输入流加载文件进内存
        //2.1 找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/image/" + filename);
        // 2.2 用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        System.out.println(realPath);

        //3. 设置response的响应头
        //3.1 设置响应头类型：content-type
        System.out.println(filename);
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type", mimeType);
        System.out.println(filename);
        // 解决中文乱码
        // 1. 获取user-agent请求头
        String agent = req.getHeader("user-agent");

        // 2. 使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);
        System.out.println(filename);

        //3.2 设置响应头打开方式：content-disposition
        resp.setHeader("content-disposition", "attachment;filename=" + filename);




        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = resp.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len = 0;

        while ((len = fis.read(bytes)) != -1) {
            sos.write(bytes, 0, len);
        }

        fis.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }
}
