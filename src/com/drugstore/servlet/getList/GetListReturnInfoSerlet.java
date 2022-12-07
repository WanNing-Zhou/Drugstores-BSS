package com.drugstore.servlet.getList;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周万宁
 * @className GetListReturnInfoSerlet
 * @create 2022/12/5-21:40
 * @description 搜索退货信息接口
 */
@WebServlet("/search/returninfo")
public class GetListReturnInfoSerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String searchstr = req.getParameter("searchstr");


//        GetForListService sev = ServiceSingleton.getGetForListService();
//
//        List<DrugInfo> allDrugInfo = sev.getAllDrugInfo();
        String re = JSON.toJSONString("");

        System.out.println(re);
        resp.getWriter().write(re);
    }


}
