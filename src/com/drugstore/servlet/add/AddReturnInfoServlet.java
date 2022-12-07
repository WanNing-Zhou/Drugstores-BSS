package com.drugstore.servlet.add;

import com.alibaba.fastjson.JSON;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.AddInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 周万宁
 * @className AddReturnInfoServlet
 * @create 2022/12/5-20:17
 * @description 添加退货信息的接口
 */
@WebServlet("/add/returnInfo")
public class AddReturnInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        AddInfoService sev = ServiceSingleton.getAddInfoService();
        String drugID = req.getParameter("drugID");
        String drugName = req.getParameter("drugName");
        String purchasingPrice = req.getParameter("purchasingPrice");
        String number = req.getParameter("number");
        String customerId = req.getParameter("customerId");


        //将结果返回给前端页面
        boolean b = sev.addReturnInfo(drugID, drugName,purchasingPrice,number,customerId);
        String re = JSON.toJSONString(b);
        resp.getWriter().write(re);


        //通过获取session域内的position来获取用户的职位重定向到指定页面
        HttpSession session = req.getSession();
        String position =(String)session.getAttribute("position");
        if(position=="经理"){
            resp.sendRedirect(req.getContextPath()+"/HTML/manager/returnGoods.html");
        }else{
            resp.sendRedirect(req.getContextPath()+"/HTML/staff/staffReturnGoodsPage.html");
        }


    }
}
