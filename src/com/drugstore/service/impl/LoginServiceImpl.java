package com.drugstore.service.impl;

import com.drugstore.bean.EmployeesInfo;
import com.drugstore.dao.EmployeesInfoDAO;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.service.LoginService;
import com.drugstore.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @author 周万宁
 * @className LoginService
 * @create 2022/12/3-12:33
 * @description 用于登录验证
 */
public class LoginServiceImpl implements LoginService {

   /**
    * @MethodName userPosition
    * @Author 周万宁
    * @Description 根据id密码返回用户职位,用于登录验证操作,如果返回为null,代表id密码错误
    * @Date 13:55 2022/12/3
    * @Param [id, password]
    * @return java.lang.String
    **/
    @Override
    public String userPosition(String id,String password) {
        Connection conn = null;
        EmployeesInfoDAO emplDAO = null;
        EmployeesInfo empl = null;
        String postion = null;
        try {
            conn = JDBCUtils.getConnection();
            emplDAO= DAOSingleton.getEmployeesInfoDAO();
            empl = emplDAO.getByIDAndPassword(conn, id, password);
            if (empl!=null){
                postion = empl.getPosition();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        return postion;
    }
}
