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
 * @className AddOutboundInfoService
 * @create 2022/12/5-20:13
 * @description 添加出库信息
 */
@WebServlet("/manage/add/outbound")
public class AddOutboundInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("/manage/add/outbound被请求");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AddInfoService sev = ServiceSingleton.getAddInfoService();
        String drugID = req.getParameter("drugID");
        String drugName = req.getParameter("drugName");
        String purchasingPrice = req.getParameter("purchasingPrice");
        String number = req.getParameter("number");
        String supplierID = req.getParameter("supplierID");

        //将结果返回给前端页面
        boolean b = sev.addOutboundInfo(drugID,drugName,purchasingPrice,number,supplierID);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);

        resp.sendRedirect(req.getContextPath()+"/HTML/manager/issue.html");

    }
}
