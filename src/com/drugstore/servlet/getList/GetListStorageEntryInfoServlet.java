package com.drugstore.servlet.getList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周万宁
 * @className GetListStorageEntryInfoServlet
 * @create 2022/12/5-21:45
 * @description 搜索入库信息接口
 */
@WebServlet("/manager/search/storage")
public class GetListStorageEntryInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
