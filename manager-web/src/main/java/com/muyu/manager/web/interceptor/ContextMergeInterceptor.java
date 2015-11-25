
package com.muyu.manager.web.interceptor;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 */
public class ContextMergeInterceptor extends HandlerInterceptorAdapter {

    @Value("${fensiquan.login.url}")
    private String loginUrl;



    private static final Logger LOGGER = LoggerFactory.getLogger(ContextMergeInterceptor.class);

    /**
     * 在具体业务方法被执行前调用,初始化登录信息的上下文
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        // 1 从session拿用户信息
        String requestUrl = ((HttpServletRequest) request).getRequestURI();
        // 2 登录鉴权
        if (!isLogin(request,response) && !isWhiteUrl(requestUrl)) { //如果是白名单url，则不进行校验
            // 3 jsonp,json请求, 返回json格式未登录状态
//            if (isJsonRequest(request)) {
//                ResponseUtils.writeJsonResponse(request, response, JSON.parse("{isLogin:false}"));
//            } else {
//                // 4 html页面请求,跳转到登录页
//                String url = request.getRequestURL().toString();
//                String query = request.getQueryString();
//                if (StringUtils.isNotBlank(query)) {
//                    url = url + "?" + query;
//                }
//                String go = loginUrl + URLEncoder.encode(url, "UTF-8");
//                response.sendRedirect(go);
//            }
//            return false;
        }
        return true;
    }

    private boolean isLogin(HttpServletRequest request, final HttpServletResponse response){
        return true;
    }
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        if (modelAndView == null
                || StringUtils.startsWithIgnoreCase(modelAndView.getViewName(), "redirect:")
                || (modelAndView.getView() != null && modelAndView.getView() instanceof RedirectView)) {
            return;
        }

    }
    private boolean isWhiteUrl(String url){
        return false;
    }
}
