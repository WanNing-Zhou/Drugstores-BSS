package com.drugstore.servlet.longin;

import com.drugstore.factory.ServiceSingleton;
import com.drugstore.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        //获取员工ID
        String eid = req.getParameter("ID");
        //获取密码
        String password = req.getParameter("password");
        String userPosition = null;
        if(eid!="admin"){

            LoginService loginService = ServiceSingleton.getLoginService();

            userPosition = loginService.userPosition(eid, password);

        }else {
            userPosition = "经理";
        }

        if(userPosition!=null){
            req.getSession().setAttribute("postion",userPosition);
            req.getSession().setAttribute("ID",eid);

        }else {
            System.out.println("登录失败");
            req.getRequestDispatcher("/HTML/login/index.jsp").forward(req,resp);
        }

    }
}
