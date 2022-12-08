package com.drugstore.servlet.getList;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.DrugInfo;
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
 * @className GetListDrugInfoServlet
 * @create 2022/12/5-21:33
 * @description 搜索药品接口
 */
@WebServlet("/search/drug")
public class GetListDrugInfoServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        System.out.println("/search/drug被访问");
        String searchstr = req.getParameter("searchstr");


        GetForListService sev = ServiceSingleton.getGetForListService();
//
        List<DrugInfo> allInfo = sev.getAllDrugInfoWithFuzzySearch(searchstr);
        String re = JSON.toJSONString(allInfo);

//        System.out.println(re);
        resp.getWriter().write(re);
    }
}
