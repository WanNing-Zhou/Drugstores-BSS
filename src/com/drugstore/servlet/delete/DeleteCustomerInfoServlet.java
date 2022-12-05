package com.drugstore.servlet.delete;

import com.alibaba.fastjson.JSON;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.AddInfoService;
import com.drugstore.service.DeleteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周万宁
 * @className DeleteCustomerInfoServlet
 * @create 2022/12/5-20:28
 * @description 删除顾客接口
 */
@WebServlet("/manager/delete/customer")
public class DeleteCustomerInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        DeleteService sev = ServiceSingleton.getDeleteService();
        String phone = req.getParameter("phone");

        //将结果返回给前端页面
        boolean b = sev.deleteCustomerInfoByPhone(phone);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);
    }
}
