package com.drugstore.servlet.update;

import com.alibaba.fastjson.JSON;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周万宁
 * @className UpdateDrugInfoServlet
 * @create 2022/12/5-21:03
 * @description 更改药品信息接口
 */
@WebServlet("/manage/update/drug")
public class UpdateDrugInfoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        UpdateService sev = ServiceSingleton.getUpdateService();
        String drugID = req.getParameter("drugID");
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
        boolean b = sev.updateDrugInfo(drugID,name,supplierID,batchNumber,placeOfOrigion,categoryOfOwnership,purchasingPrice,unitPrice,inventory,dateOfProduction,dateOfExpiry);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);

        resp.sendRedirect(req.getContextPath()+"/HTML/manager/drugs.html");

    }
}
