package com.drugstore.servlet.exit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 周万宁
 * @className ExitServlet
 * @create 2022/12/8-2:53
 * @description 退出功能
 */
@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //清除session域
        HttpSession session = req.getSession();
        session.removeAttribute("position");
        session.removeAttribute("ID");
    }
}
