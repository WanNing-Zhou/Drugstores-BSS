package com.drugstore.servlet.update;

import com.alibaba.fastjson.JSON;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周万宁
 * @className UpdateEmployeesInfoServlet
 * @create 2022/12/5-21:11
 * @description 更改员工信息接口
 */

@WebServlet("/manage/update/employee")
public class UpdateEmployeesInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        UpdateService sev = ServiceSingleton.getUpdateService();
        String employeesID = req.getParameter("employeesID");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String position = req.getParameter("position");
        String phone = req.getParameter("phone");

        System.out.println("emID"+employeesID);
        System.out.println("name"+name);
        System.out.println("phone"+phone);
        System.out.println("position"+position);

        //将结果返回给前端页面
        boolean b = sev.updateEmployeesInfoDAO(employeesID,name,password,position,phone);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);

        resp.sendRedirect(req.getContextPath()+" /HTML/manager/staff.html");

    }
}
