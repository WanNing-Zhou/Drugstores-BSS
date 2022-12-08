package com.drugstore.servlet.getList;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.DrugInfo;
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
 * @className GetListFinancialRevenueAndExpenditureInfoServlet
 * @create 2022/12/5-21:37
 * @description 搜索财政收支接口
 */
@WebServlet("/manager/search/frae")
public class GetListFinancialRevenueAndExpenditureInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String searchstr = req.getParameter("searchstr");


       resp.getWriter().write("暂未开发");
    }
}
