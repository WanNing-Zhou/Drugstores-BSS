package com.drugstore.servlet.getAll;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.CustomerInfo;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.GetForListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 周万宁
 * @className GetAllCustomerServlet
 * @create 2022/12/5-15:13
 * @description 响应所有顾客信息
 */
@WebServlet("/manager/getAllCustomer")
public class GetAllCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        GetForListService sev = ServiceSingleton.getGetForListService();

        List<CustomerInfo> allCustomerInfo = sev.getAllCustomerInfo();
        String re = JSON.toJSONString(allCustomerInfo);

        resp.getWriter().write(re);


    }
}
