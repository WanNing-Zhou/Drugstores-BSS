package com.drugstore.servlet.getAll;

import com.alibaba.fastjson.JSON;
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
 * @author 董超群
 * @className GetAllDrugInfo
 * @create 2022/12/5-15:31
 * @description 获取所有的药品信息
 */
//请求路径
@WebServlet("/all/drug")
public class GetAllDrugInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("/all/drug被请求");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        GetForListService sev = ServiceSingleton.getGetForListService();

        List<DrugInfo> allDrugInfo = sev.getAllDrugInfo();
        //转换成json格式
        String re = JSON.toJSONString(allDrugInfo);
        //[{"user":"董超群",age:20},{"user":"ljc",age:"22}]
        System.out.println(re);

        resp.getWriter().write(re);//将获取到的数据响应给服务器

    }
}
