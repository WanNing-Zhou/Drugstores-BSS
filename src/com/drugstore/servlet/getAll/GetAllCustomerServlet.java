package com.drugstore.servlet.getAll;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.drugstore.bean.CustomerInfo;
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
 * @className GetAllCustomerServlet
 * @create 2022/12/5-15:13
 * @description 响应所有顾客信息
 */
//请求路径
@WebServlet("/all/customer")
//继承HttpServlet类
public class GetAllCustomerServlet extends HttpServlet {
    //重写get方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println("/all/customer被请求");

        //设置编码集
        req.setCharacterEncoding("UTF-8");//请求的编码
        resp.setCharacterEncoding("UTF-8");//响应的编码

        //获取一个GetForListService实例
        GetForListService sev = ServiceSingleton.getGetForListService();
        //调用getAllCustomerInfo方法获取所有的顾客信息
        List<CustomerInfo> allCustomerInfo = sev.getAllCustomerInfo();

        //将获取到的信息转换为json格式  {"user":"董超群","age":20}  key:value   {"key":value}
        //目的方便前端js获取数据
        String re = JSON.toJSONString(allCustomerInfo);

        //将转换后的数据响应给浏览器
        resp.getWriter().write(re);


    }
}

