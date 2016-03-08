package com.muyu.manager.web.view;


import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * User: Yanxiaoxu
 * Date: 13-10-21
 * Time: 下午2:30
 */
public class FastJsonJsonpView extends FastJsonJsonView {

    public static final String DEFAULT_CONTENT_TYPE = "application/javascript";

    @Override
    public String getContentType() {
        return DEFAULT_CONTENT_TYPE;
    }

    /**
     * Prepares the view given the specified model, merging it with static
     * attributes and a RequestContext attribute, if necessary.
     * Delegates to renderMergedOutputModel for the actual rendering.
     *
     * @see #renderMergedOutputModel
     */
    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (!"GET".equals(request.getMethod().toUpperCase())) {
            super.render(model, request, response);
            return;
        }

        final String callback = request.getParameter("callback");
        if (callback == null) {
            super.render(model, request, response);
            return;
        }

        response.setContentType(DEFAULT_CONTENT_TYPE);
        response.getOutputStream().write((callback + "(").getBytes());
        super.render(model, request, response);
        response.getOutputStream().write(");".getBytes());
    }
}