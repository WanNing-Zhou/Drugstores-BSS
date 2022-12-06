package com.drugstore.servlet.add;

import com.alibaba.fastjson.JSON;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.AddInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周万宁
 * @className AddEmployeesInfoServlet
 * @create 2022/12/5-20:05
 * @description 员工添加
 */
@WebServlet("/manage/add/employee")
public class AddEmployeesInfoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AddInfoService sev = ServiceSingleton.getAddInfoService();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String position = req.getParameter("position");
        String phone = req.getParameter("phone");

        System.out.println(name);
        System.out.println(password);


        //将结果返回给前端页面
        boolean b = sev.addEmployeesInfo(name,password,position,phone);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);
        System.out.println("b");

        resp.sendRedirect(req.getContextPath()+"/HTML/manager/staff.html");

    }
}
