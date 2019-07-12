package webanli.web.filter;






import com.sun.org.apache.bcel.internal.generic.IFEQ;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 0. 强制转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1. 获取资源请求路径
        String uri = request.getRequestURI();
        //2. 判断是否包含登录相关资源路径
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")){
            // 包含，用户就是想登录。放行
            filterChain.doFilter(request, response);

        }else {
            // 不包含，需要验证用户是否登录
            // 3. 从获取session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user != null){
                // 登录了。放行
                filterChain.doFilter(request, response);
            }else {
                // 没有登录，跳转登录页

                request.setAttribute("login_msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
