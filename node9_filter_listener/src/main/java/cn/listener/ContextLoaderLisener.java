package cn.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderLisener implements ServletContextListener {
    /**
     * 监听servletContext对象的创建，servletContext对象服务器启动后自动创建
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 加载资源文件
        // 1. 获取servletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();
        // 2.

        System.out.println("servletContext对象的创建了");
    }

    /**
     * 在服务器正常关闭时，servletContext对象被销毁
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletContext对象的销毁了");
    }
}
