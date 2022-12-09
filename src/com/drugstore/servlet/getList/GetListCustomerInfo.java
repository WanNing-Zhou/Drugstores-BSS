package com.drugstore.servlet.getList;

import com.alibaba.fastjson.JSON;
import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.DrugInfo;
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
 * @author 卢明德
 * @className GetListCustomerInfo
 * @create 2022/12/5-21:31
 * @description 搜索操作的接口
 */

//请求地址
@WebServlet("/search/customer")
//继承HttpServlet类
public class GetListCustomerInfo extends HttpServlet {

    //重写doget用来处理请求信息以及响应
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码集
        resp.setHeader("Content-type", "text/html;charset=UTF-8");//设置响应头(告诉浏览器的)
        resp.setCharacterEncoding("UTF-8");//设置响应的编码
        req.setCharacterEncoding("UTF-8");//设置请求的编码

        //获取搜索的字符串
        String searchstr = req.getParameter("searchstr");

        //获取GetForListService实例用来调用里面的方法
        GetForListService sev = ServiceSingleton.getGetForListService();

        //根据getAllCustInfoWithFuzzySearch获取查询到的数据,保存到list内
        List<CustomerInfo> allInfo = sev.getAllCustInfoWithFuzzySearch(searchstr);
//        System.out.println(searchstr);
        //将数据转换成json格式
        String re = JSON.toJSONString(allInfo);

//        System.out.println(re);
        //转换后的数据响应给浏览器
        resp.getWriter().write(re);
    }
}
