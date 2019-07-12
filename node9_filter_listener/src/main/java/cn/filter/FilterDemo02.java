package cn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/*")
public class FilterDemo02 implements Filter {
    /**
     * 在服务器启动后会创建filter对象，调用init方法，只执行一次
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...........");
    }

    /**
     * 每一次请求被拦截时会执行，可执行多次
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo02执行了....");

        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("filterDemo02回来了....");
    }

    /**
     *
     * 在服务器关闭后，filter对象被销毁，如果服务器正常关闭，则会执行destroy方法，只执行一次
     *
     */
    @Override
    public void destroy() {
        System.out.println("destroy...........");
    }
}
