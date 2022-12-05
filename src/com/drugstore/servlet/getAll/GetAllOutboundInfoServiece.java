package com.drugstore.servlet.getAll;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.MarketingInfo;
import com.drugstore.bean.OutboundInfo;
import com.drugstore.factory.DAOSingleton;
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
 * @className GetAllOutboundInfoServiece
 * @create 2022/12/5-15:46
 * @description 获取所有的出库信息
 */

@WebServlet("/manager/all/outbound")
public class GetAllOutboundInfoServiece extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        GetForListService sev = ServiceSingleton.getGetForListService();

        List<OutboundInfo> Infos = sev.getALLOutboundInfo();
        String re = JSON.toJSONString(Infos);
        resp.getWriter().write(re);
    }


}
