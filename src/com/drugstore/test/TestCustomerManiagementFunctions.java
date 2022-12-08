package com.drugstore.test;

import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.EmployeesInfo;
import com.drugstore.dao.CustomerInfoDAO;
import com.drugstore.dao.EmployeesInfoDAO;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.utils.JDBCUtils;
import org.junit.Test;
import java.sql.Connection;
import java.util.List;

public class TestCustomerManiagementFunctions {
    public static void main(String[] args) {
        System.out.println("Test customer management functions");
    }

    @Test
    public void testAddCustomerInfo() {
        CustomerInfoDAO customerInfoDAO=null;
        Connection conn =null;
        int num = 0;
        try {
            //获取DAO实例
            customerInfoDAO = DAOSingleton.getCustomerInfoDAO();
            //获取Connection实例
            conn = JDBCUtils.getConnection();
            CustomerInfo customerInfo = new CustomerInfo();
            String name = "ljs";
            String phone = "456123";
            customerInfo.setName(name);
            customerInfo.setPhone(phone);
            //返回影响数据的条数
            num = customerInfoDAO.insert(conn, customerInfo);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testUpdateCustomerInfo() {
        Connection conn = null;
        int num = 0;
        try {
            conn = JDBCUtils.getConnection();
            String name = "dcq";
            String phone = "123456";
            CustomerInfo cust = new CustomerInfo(name,phone);
            num = DAOSingleton.getCustomerInfoDAO().updateByPhone(conn,cust);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetAllCustomerInfo() {
        Connection conn = null;
        List<CustomerInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            CustomerInfoDAO dao = DAOSingleton.getCustomerInfoDAO();
            list = dao.getAllCust(conn);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testGetAllCustInfoWithFuzzySearch() {
        Connection conn = null;
        List<CustomerInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            CustomerInfoDAO dao = DAOSingleton.getCustomerInfoDAO();
            String incompleteName = "l";
            String incompletePhone = "6";
            list = dao.getAllCustWithFuzzySearch(conn, incompleteName, incompletePhone);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testgetCustomerInfoByPhone() {
        Connection conn = null;
        CustomerInfo cust = null;
        try {
            conn = JDBCUtils.getConnection();
            CustomerInfoDAO dao = DAOSingleton.getCustomerInfoDAO();
            String phone = "123456";
            cust =  dao.getByPhone(conn,phone);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        System.out.println(cust);
    }
}
