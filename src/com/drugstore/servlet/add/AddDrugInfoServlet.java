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
 * @className AddDrugInfoServlet
 * @create 2022/12/5-19:53
 * @description 添加药品信息
 */
@WebServlet("/manager/add/drug")
public class AddDrugInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AddInfoService sev = ServiceSingleton.getAddInfoService();
        String id = getInitParameter("ID");
        String name = req.getParameter("name");
        String supplierID = req.getParameter("supplierID");
        String batchNumber = req.getParameter("batchNumber");
        String placeOfOrigion = req.getParameter("placeOfOrigion");
        String categoryOfOwnership = req.getParameter("categoryOfOwnership");
        String purchasingPrice = req.getParameter("purchasingPrice");
        String unitPrice = req.getParameter("unitPrice");
        String inventory = req.getParameter("inventory");
        String dateOfProduction = req.getParameter("dateOfProduction");
        String dateOfExpiry = req.getParameter("dateOfExpiry");


        //将结果返回给前端页面
        boolean b = sev.addDrugInfo(id,name,supplierID,batchNumber,placeOfOrigion,categoryOfOwnership,purchasingPrice,unitPrice,inventory,dateOfProduction,dateOfExpiry);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);
    }
}
