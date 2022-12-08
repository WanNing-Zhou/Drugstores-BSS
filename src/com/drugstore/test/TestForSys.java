package com.drugstore.test;

import com.drugstore.bean.EmployeesInfo;
import com.drugstore.dao.EmployeesInfoDAO;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className TestForSys
 * @create 2022/12/5-19:25
 * @description 测试类
 */
public class TestForSys {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            //获取数据库连接
             conn = JDBCUtils.getConnection();
             //通过单例工厂获取dao
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();

            //如果不知道方法的参数可以 ctrl + p 来获取参数提示
            //使用dao对员工进行操作
            //因为要添加,所以需要新建一个empl实例
            EmployeesInfo empl = new EmployeesInfo("张三","123456","员工","123456");
            dao.insert(conn,empl);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //记得要关闭数据库连接
            JDBCUtils.closeResource(conn,null);
        }
    }
    
    @Test
    public void testgetForList(){
        Connection conn = null;
        List<EmployeesInfo> elist = null;
        try {
            //获取数据库连接
            conn = JDBCUtils.getConnection();
            //通过单例工厂获取dao
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();

            //如果不知道方法的参数可以 ctrl + p 来获取参数提示
            //使用dao对员工进行操作
            //因为要添加,所以需要新建一个empl实例
           ;
            elist = dao.getAllEmpl(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //记得要关闭数据库连接
            JDBCUtils.closeResource(conn,null);
        }
        System.out.println(elist);
    }

}
