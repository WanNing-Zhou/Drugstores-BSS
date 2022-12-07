package com.drugstore.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


/**
 * @author 周万宁
 * @className LoginFilter
 * @create 2022/12/5-10:35
 * @description 拦截未登录访问操作
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {

    public static String defaultUrl;
    // 不拦截的资源类型//静态资源
    private static String[] ignoreTypes={"img","png","css","min.js","js"};
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        defaultUrl = filterConfig.getInitParameter("defaultUrl");
        String ignoreTypes = filterConfig.getInitParameter("ignoreTypes");
        if (ignoreTypes != null && !ignoreTypes.trim().equals("")) {
            this.ignoreTypes = ignoreTypes.split(",");
        }
    }

    /**
     * @MethodName doFilter
     * @Author 周万宁
     * @Description 拦截请求做权限检查
     * @Date 10:37 2022/12/5
     * @Param [servletRequest, servletResponse, filterChain]
     * @return void
     **/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        System.out.println("contextpath: "+ contextPath);
        System.out.println("requireURI: "+requestUri);

        boolean isIgnoreType = false;
        if(ignoreTypes != null){
            for (int i = 0; i < ignoreTypes.length; i++) {
                if (url.endsWith("." + ignoreTypes[i])) {
                    isIgnoreType = true;
                    break;
                }
            }
        }else{
            filterChain.doFilter(request, response);
        }
        System.out.println("静态资源" + isIgnoreType);
        if(requestUri.indexOf("/md5.js") > -1||url.indexOf("/login.html")>-1||isIgnoreType==true){
            System.out.println(url+"这是登录入口或者静态资源，放行");
            filterChain.doFilter(request, response);
        }else{
            String postion = (String)request.getSession().getAttribute("positon");
            if(postion==null){
                response.sendRedirect(contextPath+"/HTML/login/login.html");
            }else if(postion=="经理"){

                if(contextPath.indexOf("/staff/") > -1){
                    response.getWriter().write("经理是不是被降职了??!!!");
                }else {
                    System.out.println("经理登录");
                    filterChain.doFilter(request,response);
                }

            }else if(postion=="员工"){
                if(contextPath.indexOf("/manager/") > -1){
                    response.getWriter().write("抱歉,您无权访问");
                }else {
                    System.out.println("员工登录");
                    filterChain.doFilter(request,response);
                }
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
        Filter.super.destroy();
    }
}
