package org.ssmmaven.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class BaseHandlerInterceptor implements HandlerInterceptor {


    /**
     * 进入Handler方法之前执行
     *
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @param handler
     *            handler
     * @return true(放行) or false(拦截)
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 获取登录人的账号
        Integer woId = (Integer) request.getSession().getAttribute("id");
        // 获取请求路径
        String servletPath = request.getServletPath();
        // 判断是否是登录请求和获取验证码图片
        if (servletPath.equals("/test.html") || servletPath.equals("/login.ajax")
                || servletPath.equals("/image_code.jpg")) {
            // 如果是登录页面请求和登录ajax和验证码图片请求则放过
            return true;
        } else {
            // 否则判断是否已登录
            if (woId != null) {
                // 如果已登录则放过
                return true;
            } else {
                // 如果未登录则跳转登录界面
                response.sendRedirect("test.html");
                return false;
            }
        }
    }

    /**
     * 进入Handler方法之后，返回modelAndView之前执行(可以往MV里面填充公用的ModelAndView)
     *
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @param handler
     *            handler
     * @param mv
     *            ModelAndView
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
            throws Exception {
        // System.out.println("mv 执行");
    }

    /**
     * 执行Handler完成后执行(统一异常处理，统一日志处理)
     *
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @param handler
     *            handler
     * @param e
     *            异常信息
     */

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
            throws Exception {
// System.out.println("mv 执行之后");
    }

}
