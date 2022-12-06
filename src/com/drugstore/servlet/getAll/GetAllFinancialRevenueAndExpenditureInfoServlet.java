package com.drugstore.servlet.getAll;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.FinancialRevenueAndExpenditureInfo;
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
 * @className GetAllFinancialRevenueAndExpenditureInfoServlet
 * @create 2022/12/5-15:35
 * @description 获取所有的收支记录
 */
@WebServlet("/manage/all/frae")
public class GetAllFinancialRevenueAndExpenditureInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        GetForListService sev = ServiceSingleton.getGetForListService();

        List<FinancialRevenueAndExpenditureInfo> allFinancialRevenueAndExpenditureInfo = sev.getAllFinancialRevenueAndExpenditureInfo();

        String re = JSON.toJSONString(allFinancialRevenueAndExpenditureInfo);

        resp.getWriter().write(re);


    }
}
