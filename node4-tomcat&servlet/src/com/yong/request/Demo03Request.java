package com.yong.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示请求头
 *          user-agent  ：兼容操作
 *          referer     ： 防盗链演示
 *
 *
 */
@WebServlet("/Demo03Request")
public class Demo03Request extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取指定请求头
        // 1.  演示获取请求头数据：user-agent
        String agent = req.getHeader("user-agent");

        // 判断agent的浏览器版本
        if(agent.contains("Chrome")){
            System.out.println("谷歌浏览器发出 的请求！");
        }else if (agent.contains("Firefox")){
            System.out.println("火狐浏览器发出 的请求！");
        }


        // 2. 演示获取请求头数据：referer
        String referer = req.getHeader("referer");

        System.out.println(referer);

        if(referer != null){
            if (referer.contains("/node4")){
                // 正常访问
                // System.out.println("播放电影！");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("播放电影！");
            }else {
                // 盗链
                // System.out.println("想看电影，来node4！");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("想看电影，来node4！");
            }
        }

    }
}
