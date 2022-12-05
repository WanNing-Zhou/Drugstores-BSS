package com.drugstore.servlet.getAll;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.EmployeesInfo;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.GetForListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 周万宁
 * @className GetAllEmployeesInfoServlet
 * @create 2022/12/5-15:20
 * @description 响应所有员工信息
 */

@WebServlet("/manager/getAllEmployeesInfo")
public class GetAllEmployeesInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        GetForListService sev = ServiceSingleton.getGetForListService();

        List<EmployeesInfo> allEmployeesInfo = sev.getAllEmployeesInfo();

        String re = JSON.toJSONString(allEmployeesInfo);
        resp.getWriter().write(re);

    }
}
