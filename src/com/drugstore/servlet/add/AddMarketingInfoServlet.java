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
 * @className AddMarketingInfoServlet
 * @create 2022/12/5-20:09
 * @description 添加销售信息
 */
@WebServlet("/add/market")
public class AddMarketingInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AddInfoService sev = ServiceSingleton.getAddInfoService();
        String drugID = req.getParameter("drugID");
        String drugName = req.getParameter("drugName");
        String unitPrice = req.getParameter("unitPrice");
        String number = req.getParameter("unitPrice");
        String customerID = req.getParameter("customerID");

        //将结果返回给前端页面
        boolean b = sev.addMarketingInfo(drugID,drugName,unitPrice,number,customerID);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);
    }
}
