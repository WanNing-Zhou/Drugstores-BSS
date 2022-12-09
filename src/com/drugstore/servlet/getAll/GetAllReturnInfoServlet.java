package com.drugstore.servlet.getAll;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.ReturnInfo;
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
 * @className GetAllReturnInfoServlet
 * @create 2022/12/5-15:55
 * @description 获取所有退货信息
 */
@WebServlet("/all/returninfo")
public class GetAllReturnInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        GetForListService sev = ServiceSingleton.getGetForListService();

        List<ReturnInfo> Infos = sev.getAllReturnInfo();
        String re = JSON.toJSONString(Infos);
        resp.getWriter().write(re);
    }

}
