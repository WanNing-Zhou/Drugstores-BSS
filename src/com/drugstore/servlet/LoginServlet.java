package com.drugstore.servlet;

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
        String passwoed = req.getParameter("password");



    }
}
