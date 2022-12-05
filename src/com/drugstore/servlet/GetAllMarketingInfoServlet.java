package com.drugstore.servlet;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.MarketingInfo;
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
 * @className GetAllMarketingInfoServlet
 * @create 2022/12/5-15:38
 * @description 获取所有的销售信息
 */
@WebServlet ("/manager/getMarketingInfo")
public class GetAllMarketingInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        GetForListService sev = ServiceSingleton.getGetForListService();

        List<MarketingInfo> marketingInfos = sev.getAllMarketingInfo();
        String re = JSON.toJSONString(marketingInfos);
        resp.getWriter().write(re);
    }
}
