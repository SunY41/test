package com.qfedu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter( "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) req).getSession(false);
        String requestURI = ((HttpServletRequest) req).getRequestURI();
        System.out.println(session);
        if (requestURI.endsWith("login.jsp")||requestURI.endsWith("login.html")||requestURI.endsWith("index.html")||requestURI.endsWith("register.html")||requestURI.endsWith("UserFuzzyServlet")||requestURI.endsWith("LoginServlet")||requestURI.endsWith("css")){
            chain.doFilter(req, resp);
        }else if (session == null || session.getAttribute("username") == null) {
            //不能放行，跳转到登录页面
            ((HttpServletResponse)resp).sendRedirect("/test_sy/after/login.jsp");
        } else if (session != null && session.getAttribute("username") != null) {
            chain.doFilter(req, resp);
        }
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
