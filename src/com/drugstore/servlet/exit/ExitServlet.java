package com.drugstore.servlet.exit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 李建昌
 * @className ExitServlet
 * @create 2022/12/8-2:53
 * @description 退出功能
 */


//请求地址
@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    //请求method
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取session实例
        HttpSession session = req.getSession();
        //根据key值清除session中的信息
        session.removeAttribute("position");
        session.removeAttribute("ID");
    }
}
