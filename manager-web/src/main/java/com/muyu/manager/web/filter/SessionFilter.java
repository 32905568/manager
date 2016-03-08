package com.muyu.manager.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤静态资源
 */
public class SessionFilter implements Filter {
    String sessionKey;
    String excludeUrlPattern;
    String loginUrl;
    String logoutUrl;

    public void init(FilterConfig config) throws ServletException {
        sessionKey = config.getInitParameter("sessionKey");
        excludeUrlPattern = config.getInitParameter("excludeUrlPattern");
        loginUrl = config.getInitParameter("loginUrl");
        logoutUrl = config.getInitParameter("logoutUrl");
    }

    /**
     * 过滤器检查用户是否已经登录过
     * 检查规则：
     *      1 读取cookie，看看是否有登录信息，已登录的用cookie2作为sessionKey加载session，未登录的，跳转到登录服务器
     *        登录服务器拿到请求判断是否已经在登录中心登录过，登陆过的生成ticket回调回来，应用解析ticket得到sessionKey，查询session并写入到cookie
     *      2
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
//        request.getRequestDispatcher(httpRequest.getServletPath()).forward(request, response);
        httpRequest.getCookies();
        // 判断用户是否已登录，如果已登录，就跳转到登录的url
        // 判断cookie的登录状态

        // 获取session

        //

        // 退出登录

        // 需要登录，跳转到登录也没


        // 检查通过,继续执行filter
        chain.doFilter(request,response);
    }
    public void destroy() {}

    public void toLogin(){

    }

    // 免登回调的url，验证带回来的ticket信息
    public void validTicket(){

    }

    public void toLogout(){

    }

}