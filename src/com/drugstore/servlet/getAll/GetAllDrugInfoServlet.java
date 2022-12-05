package com.drugstore.servlet.getAll;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.DrugInfo;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.GetForListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 周万宁
 * @className GetAllDrugInfo
 * @create 2022/12/5-15:31
 * @description 获取所有的药品信息
 */
public class GetAllDrugInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        GetForListService sev = ServiceSingleton.getGetForListService();

        List<DrugInfo> allDrugInfo = sev.getAllDrugInfo();
        String re = JSON.toJSONString(allDrugInfo);

        resp.getWriter().write(re);

    }
}
