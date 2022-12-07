package com.drugstore.servlet.delete;

import com.alibaba.fastjson.JSON;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.DeleteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周万宁
 * @className DeleteEmployeesInfoServlet
 * @create 2022/12/5-20:38
 * @description 删除员工信息
 */
@WebServlet("/manage/delete/employee")
public class DeleteEmployeesInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        DeleteService sev = ServiceSingleton.getDeleteService();
        String id = req.getParameter("employeesID");
        //将结果返回给前端页面
        boolean b = sev.deleteEmployeesInfo(id);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);

        //删除后进行冲定向操作
        resp.sendRedirect(req.getContextPath()+"/HTML/manager/staff.html");
    }

}
