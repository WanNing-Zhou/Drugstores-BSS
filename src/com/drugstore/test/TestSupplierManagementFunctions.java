package com.drugstore.test;

import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.EmployeesInfo;
import com.drugstore.bean.SupplierInfo;
import com.drugstore.dao.CustomerInfoDAO;
import com.drugstore.dao.EmployeesInfoDAO;
import com.drugstore.dao.SupplierInfoDAO;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.utils.JDBCUtils;
import org.junit.Test;
import java.sql.Connection;
import java.util.List;

public class TestSupplierManagementFunctions {
    public static void main(String[] args) {
        System.out.println("Test supplier management functions");
    }
    @Test
    public void testAddSupplierInfo() {
        Connection conn = null;
        int num = 0;
        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            String name = "北药";
            String agent = "ljm";
            String phone = "001212";
            String address = "北京市市海淀区HIJKLMN";
            SupplierInfo supplierInfo = new SupplierInfo(name, agent, phone, address);
            num = dao.insert(conn,supplierInfo);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testUpdateSupplierInfo() {
        Connection conn = null;
        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            String supplierID = "4";
            int id = Integer.parseInt(supplierID);
            String name = "北药";
            String agent = "ljs";
            String phone = "123678";
            String address = "中国首都";
            SupplierInfo supp = new SupplierInfo(id, name, agent, phone, address);
            num = dao.update(conn,supp);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testDeleteSupplierInfo() {
        Connection conn = null;
        int  num = 0;
        String id = "2";
        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            num = dao.delete(conn,Integer.parseInt(id));
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetAllSupplierInfo() {
        Connection conn = null;
        List<SupplierInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            list = dao.getAllSupplier(conn);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetAllSupplierInfoWithFuzzySearch() {
        Connection conn = null;
        List<SupplierInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            String incompleteName = "哈";
            String incompleteAgent = "l";
            String incompletePhone = "1";
            String incompleteAddress = "";
            list = dao.getAllSupplierWithFuzzySearch(conn, incompleteName, incompleteAgent, incompletePhone, incompleteAddress);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetSupplierInfoByID() {
        Connection conn = null;
        SupplierInfo supplierInfo = null;
        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            String id = "1";
            supplierInfo = dao.getByID(conn,Integer.parseInt(id));
            System.out.println(supplierInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}
