package com.muyu.manager.web.filter;

import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤静态资源
 */
public class AssetsExcludeFilter implements Filter {

    public static final String CONST_LOGOUT_URL = "/logout";
    public void init(FilterConfig fConfig) throws ServletException {}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        request.getRequestDispatcher(httpRequest.getServletPath()).forward(request, response);

        if(StringUtils.contains(httpRequest.getServletPath(),CONST_LOGOUT_URL) ){
            HttpSession session = httpRequest.getSession(false);
            Assertion assertion = session != null ? (Assertion) session.getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION) : null;
            session.removeAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
            session.invalidate();
        }
    }
    public void destroy() {}
}