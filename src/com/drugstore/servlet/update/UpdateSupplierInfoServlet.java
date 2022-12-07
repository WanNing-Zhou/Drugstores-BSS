package com.drugstore.servlet.update;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.DrugInfo;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.GetForListService;
import com.drugstore.service.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 周万宁
 * @className UpdateSupplierInfoServlet
 * @create 2022/12/7-16:54
 * @description 更改供应商信息
 */

@WebServlet("/manage/update/supplier")
public class UpdateSupplierInfoServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("/manage/update/supplier被请求");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        UpdateService sev = ServiceSingleton.getUpdateService();
        String supplierID = req.getParameter("supplierID");
        String name = req.getParameter("name");
        String agent = req.getParameter("agent");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");



//        //将结果返回给前端页面
//        boolean b = sev.updateEmployeesInfoDAO(employeesID,name,password,position,phone);
//        String re = JSON.toJSONString(b);
//        resp.getWriter().write(re);


    }
}
