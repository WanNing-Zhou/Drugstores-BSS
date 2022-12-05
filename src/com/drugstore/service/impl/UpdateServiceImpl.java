package com.drugstore.service.impl;

import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.DrugInfo;
import com.drugstore.bean.EmployeesInfo;
import com.drugstore.dao.DrugInfoDAO;
import com.drugstore.dao.EmployeesInfoDAO;
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
    public boolean updateDrugInfo(String drugID, String name, String supplierID, String batchNumber, String placeOfOrigion, String categoryOfOwnership, String purchasingPrice, String unitPrice, String inventory, String dateOfProduction, String dateOfExpiry) {
        Connection conn = null;
        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            DrugInfoDAO dao = DAOSingleton.getDrugInfoDAO();
            //            格式转换
            int sID = Integer.parseInt(supplierID);
            BigDecimal pp = new BigDecimal(purchasingPrice);
            BigDecimal up = new BigDecimal(unitPrice);
            int inv = Integer.parseInt(inventory);
            //确定日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dop = new Date(sdf.parse(dateOfProduction).getTime());
            Date doe = new Date(sdf.parse(dateOfExpiry).getTime());

            DrugInfo drug = new DrugInfo(drugID,name,sID,batchNumber,placeOfOrigion,categoryOfOwnership,pp,up,inv,dop,doe);
            num = dao.update(conn,drug);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
            int id = Integer.parseInt(employeesID);
            EmployeesInfo empl = new EmployeesInfo(id,name,password,position,phone);

            dao.update(conn,empl);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        if (num>0){
            return true;
        }

        return false;
    }
}
