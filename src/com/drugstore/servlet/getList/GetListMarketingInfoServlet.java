package com.drugstore.servlet.getList;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.DrugInfo;
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
 * @author 卢明德
 * @className GetListMarketingInfoServlet
 * @create 2022/12/5-21:38
 * @description 搜索销售信息接口
 */
@WebServlet("/search/market")
public class GetListMarketingInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String searchstr = req.getParameter("searchstr");

        System.out.println(searchstr);
        GetForListService sev = ServiceSingleton.getGetForListService();

        List<MarketingInfo> allInfo = sev.getAllMarketingInfoWithFuzzySearch(searchstr);
        String re = JSON.toJSONString(allInfo);
        System.out.println(re);
        resp.getWriter().write(re);
    }
}
