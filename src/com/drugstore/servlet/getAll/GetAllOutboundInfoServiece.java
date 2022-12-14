package com.drugstore.servlet.getAll;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.OutboundInfo;
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
 * @className GetAllOutboundInfoServiece
 * @create 2022/12/5-15:46
 * @description 获取所有的出库信息
 */

@WebServlet("/manage/all/outbound")
public class GetAllOutboundInfoServiece extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("/manage/all/outbound被放访问");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        GetForListService sev = ServiceSingleton.getGetForListService();

        List<OutboundInfo> infos = sev.getALLOutboundInfo();

        String re = JSON.toJSONString(infos);
        System.out.println(re);
        resp.getWriter().write(re);
    }



}
