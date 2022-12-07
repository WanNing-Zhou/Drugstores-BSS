package com.drugstore.service.impl;

import com.drugstore.bean.*;
import com.drugstore.dao.*;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.service.GetForListService;
import com.drugstore.utils.JDBCUtils;
import netscape.javascript.JSException;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className GetForListServiceImpl
 * @create 2022/12/3-21:56
 * @description 获取多行信息服务具体实现
 */
public class GetForListServiceImpl implements GetForListService {

    /**
     * @MethodName getAllCustomerInfo
     * @Author 周万宁
     * @Description 获取所有顾客
     * @Date 9:58 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.CustomerInfo>
     **/
    @Override
    public List<CustomerInfo> getAllCustomerInfo() {
        Connection conn = null;
        List<CustomerInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            CustomerInfoDAO dao = DAOSingleton.getCustomerInfoDAO();
            list = dao.getAllCust(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllDrugInfo
     * @Author 周万宁
     * @Description 获取所有药品信息
     * @Date 10:01 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/
    @Override
    public List<DrugInfo> getAllDrugInfo() {
        Connection conn = null;
        List<DrugInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            DrugInfoDAO dao = DAOSingleton.getDrugInfoDAO();
            list = dao.getAllDrug(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllEmployeesInfo
     * @Author 周万宁
     * @Description 获取所有员工信息
     * @Date 10:01 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.EmployeesInfo>
     **/
    @Override
    public List<EmployeesInfo> getAllEmployeesInfo() {
        Connection conn = null;
        List<EmployeesInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            list =  dao.getAllEmpl(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllFinancialRevenueAndExpenditureInfo
     * @Author 周万宁
     * @Description 获取所有收支表单
     * @Date 10:02 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.FinancialRevenueAndExpenditureInfo>
     **/
    @Override
    public List<FinancialRevenueAndExpenditureInfo> getAllFinancialRevenueAndExpenditureInfo() {
        Connection conn = null;
        List<FinancialRevenueAndExpenditureInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            FinancialRevenueAndExpenditureInfoDAO dao = DAOSingleton.getFinancialRevenueAndExpenditureInfoDAO();
            list = dao.getAllFre(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllMarketingInfo
     * @Author 周万宁
     * @Description 获取所有销售信息
     * @Date 10:04 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.MarketingInfo>
     **/
    @Override
    public List<MarketingInfo> getAllMarketingInfo() {
        Connection conn = null;
        List<MarketingInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            MarketingInfoDAO dao = DAOSingleton.getMarketingInfoDAO();
            list = dao.getAllMkt(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getALLOutboundInfo
     * @Author 周万宁
     * @Description 获取所有出库信息
     * @Date 10:05 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.OutboundInfo>
     **/
    @Override
    public List<OutboundInfo> getALLOutboundInfo() {
        Connection conn = null;
        List<OutboundInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            OutboundInfoDAO dao = DAOSingleton.getOutboundInfoDAO();
            list = dao.getALLObi(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }
    /**
     * @MethodName getAllReturnInfo
     * @Author 周万宁
     * @Description 获取所有退货信息
     * @Date 16:01 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.ReturnInfo>
     **/

    @Override
    public List<ReturnInfo> getAllReturnInfo() {

        Connection conn = null;
        List<ReturnInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            ReturnInfoDAO dao = DAOSingleton.getReturnInfoDAO();
            list = dao.getAllRet(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }


    /**
     * @MethodName getAllStorageEntryInfo
     * @Author 周万宁
     * @Description 获取所有入库信息
     * @Date 10:06 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.StorageEntryInfo>
     **/
    @Override
    public List<StorageEntryInfo> getAllStorageEntryInfo() {
        Connection conn = null;
        List<StorageEntryInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            StorageEntryInfoDAO dao = DAOSingleton.getStorageEntryInfoDAO();
            list = dao.getAllSte(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllSupplierInfo
     * @Author 周万宁
     * @Description 获取所有供应商信息
     * @Date 10:08 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.SupplierInfo>
     **/

    @Override
    public List<SupplierInfo> getAllSupplierInfo() {
        Connection conn = null;
        List<SupplierInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            list = dao.getAllSupplier(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }
}
