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
@WebFilter("/*")
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
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

//      可以替代sethearder和setcharsetencoding来解决乱码问题
//        resp.setContentType("text/html; charset=UTF-8");

        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());

//        System.out.println("contextpath: "+ contextPath);
//        System.out.println("requireURI: "+requestUri);

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
        System.out.println(url+"静态资源" + isIgnoreType);
        if(requestUri.indexOf("/login")>-1||url.indexOf("/login")>-1||isIgnoreType==true){
//            System.out.println(url+"这是登录入口或者静态资源，放行");
            filterChain.doFilter(request, response);
        }else{
            String position = (String)request.getSession().getAttribute("position");
            System.out.println("position"+position);
            if(position==null||position==""){
                response.sendRedirect(contextPath+"/HTML/login/login.html");
            }else if("经理".equals(position)){

                if(requestUri.indexOf("/staff/") > -1){
                    response.getWriter().write("经理是不是被降职了??!!!");
                }else {

                    filterChain.doFilter(request,response);
                }

            }else if("员工".equals(position)){
                if(requestUri.indexOf("/manager/") > -1){
                    response.getWriter().write("抱歉,您无权访问");
                }else {
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
