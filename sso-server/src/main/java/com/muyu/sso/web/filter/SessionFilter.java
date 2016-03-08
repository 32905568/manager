package com.muyu.sso.web.filter;

import com.muyu.sso.web.constants.CookieConstants;
import com.muyu.sso.web.constants.SessionConstants;
import com.muyu.sso.web.util.CookieUtils;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤静态资源
 */
public class SessionFilter implements Filter {
    String excludeUrlPattern;
    String loginUrl;
    String logoutUrl;

    public void init(FilterConfig config) throws ServletException {
        excludeUrlPattern = config.getInitParameter("excludeUrlPattern");
        loginUrl = config.getInitParameter("loginUrl");
        logoutUrl = config.getInitParameter("logoutUrl");
    }

    /**
     * 过滤器检查用户是否已经登录过
     * 检查规则：
     * 1 读取cookie，看看是否有登录信息，已登录的用cookie2作为sessionKey加载session，未登录的，跳转到登录服务器
     * 登录服务器拿到请求判断是否已经在登录中心登录过，登陆过的生成ticket回调回来，应用解析ticket得到sessionKey，查询session并写入到cookie
     * 2
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 检查来源和回跳页面是否一致，防止被拦截伪造请求
        // 如果是验证ticket的请求。。。
        // request.getRequestDispatcher(httpRequest.getServletPath()).forward(request, response);
        httpRequest.getCookies();
        // 判断用户是否已登录，如果已登录，就跳转回登录前的url,带上ticket、每个ticket只能用一次
        String key = CookieUtils.getCookie(httpRequest, CookieConstants.SESSION_KEY);
        String userName = CookieUtils.getCookie(httpRequest,CookieConstants.USER_KEY);
        if (StringUtils.isNotBlank(key)) {
            // 用户登录过，检查登录的信息是否还存在
            String sessionUserName = (String) httpRequest.getSession().getAttribute(SessionConstants.USER_NAME_KEY);
            if(StringUtils.equals(userName,sessionUserName)){
                // 检查通过,继续执行filter
                chain.doFilter(request, response);
                return;
            }
        }

        // 退出登录

        // 需要登录，跳转到登录也没
        toLogin(httpRequest,(HttpServletResponse)response);
    }

    public void destroy() {
    }

    public void toLogin(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect(loginUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成ticket带回去，同时加签名
     * @param request
     * @param response
     */
    public void redirectBack(HttpServletRequest request, HttpServletResponse response) {
        try {
            String redirectUrl=(String)request.getAttribute("redirectUrl");
            response.sendRedirect(redirectUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 免登回调的url，验证带回来的ticket信息
    public void validTicket() {

    }

    public void toLogout() {

    }

}