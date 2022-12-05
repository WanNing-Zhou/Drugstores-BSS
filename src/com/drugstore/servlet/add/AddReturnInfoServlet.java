package com.drugstore.servlet.add;

import com.alibaba.fastjson.JSON;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.AddInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周万宁
 * @className AddReturnInfoServlet
 * @create 2022/12/5-20:17
 * @description 添加退货信息的接口
 */
public class AddReturnInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AddInfoService sev = ServiceSingleton.getAddInfoService();
        String drugID = req.getParameter("drugID");
        String drugName = req.getParameter("drugName");
        String purchasingPrice = req.getParameter("purchasingPrice");
        String number = req.getParameter("number");
        String customerId = req.getParameter("customerId");


        //将结果返回给前端页面
        boolean b = sev.addReturnInfo(drugID, drugName,purchasingPrice,number,customerId);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);
    }
}
