package com.drugstore.servlet.longin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.LoginService;
import com.drugstore.utils.HttpGetJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author 周万宁
 * @className LoginServlet
 * @create 2022/12/5-10:11
 * @description 登录的servlet
 */
@WebServlet("/login/isuser")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        LoginService loginService = ServiceSingleton.getLoginService();
        JSONObject date = HttpGetJson.getJson(req);


        String eid = String.valueOf(date.get("ID"));
        String password = String.valueOf(date.get("password"));

        String userPosition = null;
        userPosition = loginService.userPosition(eid,password);
        System.out.println(userPosition);
        if("经理".equals(userPosition)){
            req.getSession().setAttribute("postion",userPosition);
            req.getSession().setAttribute("ID",eid);
            resp.getWriter().write(JSON.toJSONString("经理"));
        }else if ("店员".equals(userPosition)){
            req.getSession().setAttribute("position",userPosition);
            req.getSession().setAttribute("ID",eid);
            resp.getWriter().write(JSON.toJSONString("店员"));
        }else{
            boolean b = false;
            resp.getWriter().write(JSON.toJSONString(b));
        }


//        if(eid!="admin"){
//
//            LoginService loginService = ServiceSingleton.getLoginService();
//
//            userPosition = loginService.userPosition(eid, password);
//
//        }else {
//            userPosition = "经理";
//        }
//
//        if(userPosition!=null){
//            req.getSession().setAttribute("postion",userPosition);
//            req.getSession().setAttribute("ID",eid);
//
//        }else {
//            System.out.println("登录失败");
//            req.getRequestDispatcher("/HTML/login/index.jsp").forward(req,resp);
//        }

    }
}
