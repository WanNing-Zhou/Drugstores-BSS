package com.drugstore.servlet.update;

import com.alibaba.fastjson.JSON;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.AddInfoService;
import com.drugstore.service.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpClient;

/**
 * @author 周万宁
 * @className UpdateCustomerInfoServlet
 * @create 2022/12/5-20:44
 * @description 更改顾客信息接口
 */
@WebServlet("/update/customer")
public class UpdateCustomerInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("/update/customer被访问");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        UpdateService sev = ServiceSingleton.getUpdateService();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");

        //将结果返回给前端页面
        boolean b = sev.updateCustomerInfo(name, phone);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);

        //通过获取session域内的position来获取用户的职位
        HttpSession session = req.getSession();
        String position =(String)session.getAttribute("position");
        if(position.equals("经理")){
            resp.sendRedirect(req.getContextPath()+"/HTML/manager/customer.html");
        }else{
            resp.sendRedirect(req.getContextPath()+"/HTML/staff/staffCustomerPage.html");
        }

    }
}
