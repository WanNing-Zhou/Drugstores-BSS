package com.drugstore.servlet.add;

import com.alibaba.fastjson.JSON;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.AddInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 周万宁
 * @className AddMarketingInfoServlet
 * @create 2022/12/5-20:09
 * @description 添加销售信息
 */
@WebServlet("/add/market")
public class AddMarketingInfoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("/add/market被请求");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AddInfoService sev = ServiceSingleton.getAddInfoService();
        String drugID = req.getParameter("drugID");
        String drugName = req.getParameter("drugName");
        String unitPrice = req.getParameter("unitPrice");
        String number = req.getParameter("number");
        String customerID = req.getParameter("customerID");

        //将结果返回给前端页面
        boolean b = sev.addMarketingInfo(drugID,drugName,unitPrice,number,customerID);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);
        resp.sendRedirect(req.getContextPath()+"/HTML/manager/sale.html");


        //通过获取session域内的position来获取用户的职位重定向到指定页面
        HttpSession session = req.getSession();
        String position =(String)session.getAttribute("position");
        if(position=="经理"){
            resp.sendRedirect(req.getContextPath()+"/HTML/manager/returnGoods.html");
        }else{
            resp.sendRedirect(req.getContextPath()+"/HTML/staff/staffSalePage.html");
        }

    }
}
