package com.drugstore.test;

import com.drugstore.bean.EmployeesInfo;
import com.drugstore.dao.EmployeesInfoDAO;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.utils.JDBCUtils;
import org.junit.Test;
import java.sql.Connection;
import java.util.List;

public class TestEmployeesManagementFunctions {
    public static void main(String[] args) {
        System.out.println("Test employees management functions");
    }
    //测试添加店员信息功能
    @Test
    public void testAddEmployeesInfo() {
        Connection conn = null;
        int num = 0;
        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            EmployeesInfo employeesInfo = new EmployeesInfo("lmd", "qweasd", "经理", "123456");
            num = dao.insert(conn, employeesInfo);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }
    //测试更改店员信息功能
    @Test
    public void testUpdateEMployeesInfo() {
        Connection conn = null;
        int num = 0;
        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            String employeesID = "1";
            int id = Integer.parseInt(employeesID);
            EmployeesInfo employeesInfo = new EmployeesInfo(id, "ljs", "qweasd", "经理", "123456");
            num = dao.update(conn,employeesInfo);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }
    @Test
    public void testDeleteEmployeesInfo() {
        Connection conn = null;
        int num = 0;
        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            String employeesID = "2";
            int id = Integer.parseInt(employeesID);
            num =  dao.deleteByID(conn, id);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetAllEmployeesInfo() {
        Connection conn = null;
        List<EmployeesInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            list =  dao.getAllEmpl(conn);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetAllEmployeesInfoWithFuzzySearch() {
        Connection conn = null;
        List<EmployeesInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            String incompleteName = "k";
            String incompletePhone = "123";
            list =  dao.getAllWithFuzzySearch(conn, incompleteName, incompletePhone);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testgetEmployeesInfoByID() {
        Connection conn = null;
        EmployeesInfo employeesInfo = null;
        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            String id = "1";
            employeesInfo = dao.getByID(conn,Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        System.out.println(employeesInfo);
    }
}
