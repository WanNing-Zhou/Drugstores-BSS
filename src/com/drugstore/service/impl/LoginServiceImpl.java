package com.drugstore.service.impl;

import com.drugstore.bean.EmployeesInfo;
import com.drugstore.dao.EmployeesInfoDAO;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.service.LoginService;
import com.drugstore.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @author 李建昌
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
            //获取数据库连接(Connection实例)
            conn = JDBCUtils.getConnection();
            //获取一个dao实例
            emplDAO= DAOSingleton.getEmployeesInfoDAO();
            //调用dao内的这个方法,获取员工信息(getByIDAndPassword会返回一个员工实例)
            empl = emplDAO.getByIDAndPassword(conn, id, password);

            //获取职位
            postion = empl.getPosition();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭数据库连接
            JDBCUtils.closeResource(conn,null);
        }
        return postion;
    }
}
