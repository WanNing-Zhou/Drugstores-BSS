package com.drugstore.service.impl;

import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.DrugInfo;
import com.drugstore.bean.EmployeesInfo;
import com.drugstore.bean.SupplierInfo;
import com.drugstore.dao.DrugInfoDAO;
import com.drugstore.dao.EmployeesInfoDAO;
import com.drugstore.dao.SupplierInfoDAO;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.service.UpdateService;
import com.drugstore.utils.JDBCUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author 周万宁
 * @className UpdateServiceImpl
 * @create 2022/12/5-20:46
 * @description 更改信息服务具体实现
 */
public class UpdateServiceImpl implements UpdateService {
    /**
     * @MethodName updateCustomerInfo
     * @Author 周万宁
     * @Description 更改顾客信息
     * @Date 20:53 2022/12/5
     * @Param [name, phone]
     * @return boolean
     **/

    @Override
    public boolean updateCustomerInfo(String name, String phone) {
        Connection conn = null;
        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            CustomerInfo cust = new CustomerInfo(name,phone);

            num = DAOSingleton.getCustomerInfoDAO().updateByPhone(conn,cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        if(num>0){
            return true;
        }
        return false;
    }

    /**
     * @MethodName updateDrugInfo
     * @Author 周万宁
     * @Description 更改药品信息
     * @Date 20:57 2022/12/5
     * @Param [drugID, name, supplierID, batchNumber, placeOfOrigion, categoryOfOwnership, purchasingPrice, unitPrice, inventory, dateOfProduction, dateOfExpiry]
     * @return boolean
     **/
    @Override
    public boolean updateDrugInfo(String drugID, String unitPrice) {
        Connection conn = null;
        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            DrugInfoDAO dao = DAOSingleton.getDrugInfoDAO();
            BigDecimal up = new BigDecimal(unitPrice);
            num = dao.update(conn,drugID, up);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        if(num>0){
            return true;
        }
        return false;
    }

    /**
     * @MethodName updateEmployeesInfoDAO
     * @Author 周万宁
     * @Description 更改员工信息
     * @Date 20:57 2022/12/5
     * @Param [employeesID, name, password, position, phone]
     * @return boolean
     **/

    @Override
    public boolean updateEmployeesInfoDAO(String employeesID, String name, String password, String position, String phone) {
        Connection conn = null;
        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            System.out.println(employeesID);
            int id = Integer.parseInt(employeesID);
            EmployeesInfo empl = new EmployeesInfo(id,name,password,position,phone);

            num = dao.update(conn,empl);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        if (num>0){
            return true;
        }

        return false;
    }

    /**
     * @MethodName updateSupplierInfoDAO
     * @Author 周万宁
     * @Description 更改供应商信息
     * @Date 13:24 2022/12/9
     * @Param [supplierID, name, agent, phone, address]
     * @return boolean
     **/

    @Override
    public boolean updateSupplierInfoDAO(String supplierID, String name, String agent, String phone, String address) {
        Connection conn = null;
        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            int id = Integer.parseInt(supplierID);
            SupplierInfo supp = new SupplierInfo(id, name, agent, phone, address);

            num = dao.update(conn,supp);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        if (num>0){
            return true;
        }
        return false;
    }
}
