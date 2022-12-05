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
 * @className AddCustomerInfoServlet
 * @create 2022/12/5-19:44
 * @description 添加客户接口
 */
@WebServlet("/add/customer")
public class AddCustomerInfoServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AddInfoService sev = ServiceSingleton.getAddInfoService();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");

        //将结果返回给前端页面
        boolean b = sev.addCustomerInfo(name, phone);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);

    }
}
