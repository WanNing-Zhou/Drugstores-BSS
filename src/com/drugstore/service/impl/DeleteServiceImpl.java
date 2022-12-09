package com.drugstore.service.impl;

import com.drugstore.dao.CustomerInfoDAO;
import com.drugstore.dao.DrugInfoDAO;
import com.drugstore.dao.EmployeesInfoDAO;
import com.drugstore.dao.SupplierInfoDAO;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.service.DeleteService;
import com.drugstore.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @author 周万宁
 * @className DeleteServiceImpl
 * @create 2022/12/3-21:54
 * @description 删除服务实现
 */
public class DeleteServiceImpl implements DeleteService {

    /**
     * @MethodName deleteCustomerInfoByPhone
     * @Author 卢明德
     * @Description 根据phone删除顾客(这个功能有待争议)
     * @Date 18:39 2022/12/4
     * @Param [phone]
     * @return boolean
     **/
    @Override
    public boolean deleteCustomerInfoByPhone(String phone) {
        Connection conn = null;
        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            CustomerInfoDAO dao = DAOSingleton.getCustomerInfoDAO();
            num = dao.deleteByPhone(conn,phone);

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
     * @MethodName deleteDrugInfo
     * @Author 卢明德
     * @Description 根据药品Id和批次号删除药品
     * @Date 18:46 2022/12/4
     * @Param [id, batchNumber]
     * @return boolean
     **/

    @Override
    public boolean deleteDrugInfo(String id, String batchNumber) {

        Connection conn = null;
        int  num = 0;

        try {
            conn = JDBCUtils.getConnection();
            DrugInfoDAO dao = DAOSingleton.getDrugInfoDAO();
            num = dao.DeleteByIDAndBatch(conn,id,batchNumber);

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
     * @MethodName deleteEmployeesInfo
     * @Author 卢明德
     * @Description 根据ID删除员工
     * @Date 18:55 2022/12/4
     * @Param [id]
     * @return boolean
     **/
    @Override
    public boolean deleteEmployeesInfo(String id) {
        Connection conn = null;
        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();

            int i = Integer.parseInt(id);

            num =  dao.deleteByID(conn,i);

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
     * @MethodName deleteSupplierInfo
     * @Author 卢明德
     * @Description 根据id删除供应商信息
     * @Date 19:00 2022/12/4
     * @Param [id]
     * @return boolean
     **/
    @Override
    public boolean deleteSupplierInfo(String id) {
        Connection conn = null;
        int  num = 0;

        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            num = dao.delete(conn,Integer.parseInt(id));

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
}
