package com.drugstore.servlet.getAll;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.StorageEntryInfo;
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
 * @author 董超群
 * @className GetAllStorageEntryInfoServlet
 * @create 2022/12/5-16:10
 * @description 获取所有入库信息
 */

@WebServlet("/manage/all/storage")
public class GetAllStorageEntryInfoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/manage/all/storage被请求");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        GetForListService sev = ServiceSingleton.getGetForListService();

        List<StorageEntryInfo> infos = sev.getAllStorageEntryInfo();
        String re = JSON.toJSONString(infos);

        resp.getWriter().write(re);

    }
}
