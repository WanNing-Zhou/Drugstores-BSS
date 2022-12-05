package com.drugstore.servlet.longin;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.EmployeesInfo;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.LoginService;
import com.drugstore.utils.AJAXJSONUtils;

import javax.lang.model.element.NestingKind;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

/**
 * @author 周万宁
 * @className LoginServlet
 * @create 2022/12/5-10:11
 * @description 登录的servlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //获取员工ID
        String eid = req.getParameter("ID");
        //获取密码
        String password = req.getParameter("password");

        LoginService loginService = ServiceSingleton.getLoginService();

        String userPosition = loginService.userPosition(eid, password);

        EmployeesInfo employeesInfo = new EmployeesInfo(null, null, userPosition, null);

        String respJson = JSON.toJSONString(employeesInfo);
        if(userPosition!=null){
           req.getSession().setAttribute("postion",userPosition);
           req.getSession().setAttribute("ID",eid);
        }else {
            System.out.println("登录失败");
        }
        resp.getWriter().write(respJson);

    }
}
