package webanli.web.filter;


import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 0. 强制转换
        HttpRequest request = (HttpRequest) servletRequest;
        HttpResponse response = (HttpResponse) servletResponse;

        //1. 获取资源请求路径
        request
    }

    @Override
    public void destroy() {

    }
}
