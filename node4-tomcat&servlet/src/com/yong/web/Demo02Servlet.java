package com.yong.web;

import javax.servlet.*;
import java.io.IOException;

/**
 * servlet生命周期：
 *      1. 被创建时：执行init，只执行一次
 *          servlet什么时候被创建：
 *              默认情况下，第一次被访问时创建
 *              可以配置执行servlet的创建时期
 *                      指定Servlet的创建时期
 *                             1. 第一被访问时，创建
 *                                   <load-on-startup>负数</load-on-startup>
 *                            2. 在服务器启动时，创建
 *                                   <load-on-startup>0或正数</load-on-startup>
 *
 *              * Servlet的init方法，只执行一次，说明一个servlet在内存中只存在一个对象，Servlet是单例的
 *                  问题：  多个用户同时访问时，可能会出现线程安全问题
 *                  解决：  尽量不要在Servlet中定义成员变量，即使定义了成员变量，也不要修改成员变量。
 *
 *      2. 提供服务：执行service，可执行多次
 *
 *      3. 被摧毁时：执行destroy方法，只执行一次
 *
 */
public class Demo02Servlet implements Servlet {
    /**
     * 初始化方法：
     * 在servlet被创建时执行，只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init......");
    }

    /**
     * 获取ServletConfig对象
     *      ServletConfig：servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每一次执行servlet时就会被调用
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service......");
    }

    /**
     * 获取servlet一些信息：如servlet版本、作者等，一般不会去做具体实现
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在servlet被杀死时执行（在服务器被正常关闭时执行！）
     * 临终遗言
     */
    @Override
    public void destroy() {
        System.out.println("destroy......");
    }
}
