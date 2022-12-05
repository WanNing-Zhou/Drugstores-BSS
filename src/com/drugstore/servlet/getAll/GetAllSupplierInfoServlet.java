package com.drugstore.servlet.getAll;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.StorageEntryInfo;
import com.drugstore.bean.SupplierInfo;
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
 * @className getAllSupplierInfoServlet
 * @create 2022/12/5-16:13
 * @description 获取所有供应商信息
 */

@WebServlet("/all/supplier")
public class GetAllSupplierInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        GetForListService sev = ServiceSingleton.getGetForListService();

        List<SupplierInfo> infos = sev.getAllSupplierInfo();
        String re = JSON.toJSONString(infos);

        resp.getWriter().write(re);

    }

}
