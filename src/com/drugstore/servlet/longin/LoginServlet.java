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
 * @author 李建昌
 * @className LoginServlet
 * @create 2022/12/5-10:11
 * @description 登录的servlet
 */
@WebServlet("/login/isuser")
//需要继承httpServlet
public class LoginServlet extends HttpServlet {
    //重写dopost方法,来对post请求信息的获取及响应
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置字符集
        resp.setHeader("Content-type", "text/html;charset=UTF-8");//设置响应头的字符集
        resp.setCharacterEncoding("UTF-8");//设置服务器编码集
        req.setCharacterEncoding("UTF-8");

        //获取loginService的实例
        LoginService loginService = ServiceSingleton.getLoginService();

        JSONObject date = HttpGetJson.getJson(req);//获取请求的信息,将他转换成json格式
        //fastjson工具 用于json格式的转换

//        {ID:"看见电视里空间",password:"就看见看到了封杀"}
        String eid = String.valueOf(date.get("ID"));
        String password = String.valueOf(date.get("password"));
//        System.out.println("ID"+eid);
//        System.out.println("password"+password);

        String userPosition = null;
        userPosition = loginService.userPosition(eid,password);
//        System.out.println(userPosition);

        //"经理"==position 不要用 所指向的地址不同,需要用.equals方法来比较值是否相同
        if("经理".equals(userPosition)){
            //map(key,value)
            //等于经理的话,将职位于ID保存在session域中,
            //域中以key,value的形式保存类似于map(string,string)
            req.getSession().setAttribute("position",userPosition);
            req.getSession().setAttribute("ID",eid);
            //如果职位为经理的话,将结果返回给浏览器,为了方便浏览器解析,将响应结果转换为json格式,JSON.toJSONString方法 将一个对象=>json格式
            resp.getWriter().write(JSON.toJSONString("经理"));
        }else if ("店员".equals(userPosition)){
            //将信息保存在session域中
            req.getSession().setAttribute("position",userPosition);
            req.getSession().setAttribute("ID",eid);
            //响应结果
            resp.getWriter().write(JSON.toJSONString("店员"));
        }else{
            //响应false
            boolean b = false;
            resp.getWriter().write(JSON.toJSONString(b));
        }


    }
}
