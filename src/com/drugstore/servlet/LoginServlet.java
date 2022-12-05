package com.drugstore.servlet;

import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周万宁
 * @className LoginServlet
 * @create 2022/12/5-10:11
 * @description 登录的servlet
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        //获取员工ID
        String eid = req.getParameter("ID");
        //获取密码
        String password = req.getParameter("password");

        LoginService loginService = ServiceSingleton.getLoginService();

        String userPosition = loginService.userPosition(eid, password);

        if(userPosition!=null){
           req.getSession().setAttribute("postion",userPosition);
           req.getSession().setAttribute("ID",eid);

        }else {
            System.out.println("登录失败");
            req.getRequestDispatcher("/login/index.jsp").forward(req,resp);
        }

    }
}