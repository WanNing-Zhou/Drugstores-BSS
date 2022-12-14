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
 * @className AddStorageEntryInfoServlet
 * @create 2022/12/5-20:20
 * @description 添加入库信息接口
 */
@WebServlet("/manage/add/entry")
public class AddStorageEntryInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("被访问");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AddInfoService sev = ServiceSingleton.getAddInfoService();
        String drugID = req.getParameter("drugID");
        String drugName = req.getParameter("drugName");
        String purchasingPrice = req.getParameter("purchasingPrice");
        String number = req.getParameter("number");
        String supplierID = req.getParameter("supplierID");

        //将结果返回给前端页面
        boolean b = sev.addStorageEntryInfo(drugID,drugName,purchasingPrice,number,supplierID);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);

        resp.sendRedirect(req.getContextPath()+"/HTML/manager/warehousing.html");

    }
}
