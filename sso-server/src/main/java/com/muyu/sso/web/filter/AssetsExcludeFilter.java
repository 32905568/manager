package com.muyu.sso.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤静态资源
 */
public class AssetsExcludeFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        request.getRequestDispatcher(httpRequest.getServletPath()).forward(request, response);
    }
    public void destroy() {}
}