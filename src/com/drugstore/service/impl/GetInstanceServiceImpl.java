package com.drugstore.service.impl;

import com.drugstore.bean.*;
import com.drugstore.dao.*;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.service.GetInstanceService;
import com.drugstore.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @author 周万宁
 * @className GetInstanceServiceImpl
 * @create 2022/12/3-21:57
 * @description 获取实例服务具体实现
 */
public class GetInstanceServiceImpl implements GetInstanceService {
    /**
     * @MethodName getCustomerInfo
     * @Author 周万宁
     * @Description 根据电话号返回一条顾客实例
     * @Date 19:13 2022/12/4
     * @Param [phone]
     * @return com.drugstore.bean.CustomerInfo
     **/
    @Override
    public CustomerInfo getCustomerInfo(String phone) {
        Connection conn = null;
        CustomerInfo cust = null;

        try {
            conn = JDBCUtils.getConnection();
            CustomerInfoDAO dao = DAOSingleton.getCustomerInfoDAO();
            cust =  dao.getByPhone(conn,phone);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }


        return cust;
    }


    /**
     * @MethodName getEmployeesInfo
     * @Author 周万宁
     * @Description 根据id 获取employeesInfo
     * @Date 22:15 2022/12/4
     * @Param [id]
     * @return com.drugstore.bean.EmployeesInfo
     **/
    @Override
    public EmployeesInfo getEmployeesInfo(String id) {

        Connection conn = null;
        EmployeesInfo employeesInfo = null;

        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            employeesInfo = dao.getByID(conn,Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return employeesInfo;
    }

    /**
     * @MethodName getFinancialRevenueAndExpenditureInfo
     * @Author 周万宁
     * @Description 根据id获取收支表单的一条实例
     * @Date 22:19 2022/12/4
     * @Param [ID]
     * @return com.drugstore.bean.FinancialRevenueAndExpenditureInfo
     **/
    @Override
    public FinancialRevenueAndExpenditureInfo getFinancialRevenueAndExpenditureInfo(String ID) {
        Connection conn = null;
        FinancialRevenueAndExpenditureInfo fre = null;

        try {
            conn = JDBCUtils.getConnection();
            FinancialRevenueAndExpenditureInfoDAO dao = DAOSingleton.getFinancialRevenueAndExpenditureInfoDAO();
            fre = dao.getByID(conn,Integer.parseInt(ID));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return fre;
    }

    /**
     * @MethodName getMarketingInfo
     * @Author 周万宁
     * @Description TODO
     * @Date 22:39 2022/12/4
     * @Param [id]
     * @return com.drugstore.bean.MarketingInfo
     **/

    @Override
    public MarketingInfo getMarketingInfo(String id) {
        Connection conn = null;
        MarketingInfo mkt = null;
        try {
            conn = JDBCUtils.getConnection();
            MarketingInfoDAO dao = DAOSingleton.getMarketingInfoDAO();
            mkt = dao.getByID(conn,Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return mkt;
    }

    /**
     * @MethodName getOutboundInfo
     * @Author 周万宁
     * @Description 根据id获取出库信息实例
     * @Date 22:45 2022/12/4
     * @Param [id]
     * @return com.drugstore.bean.OutboundInfo
     **/
    @Override
    public OutboundInfo getOutboundInfo(String id) {
        Connection conn = null;
        OutboundInfo outboundInfo = null;

        try {
            conn = JDBCUtils.getConnection();
            OutboundInfoDAO dao = DAOSingleton.getOutboundInfoDAO();
            outboundInfo = dao.getByID(conn,Integer.parseInt(id));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }


        return outboundInfo;
    }

    /**
     * @MethodName getReturnInfo
     * @Author 周万宁
     * @Description 根据id获取退货信息实例
     * @Date 22:48 2022/12/4
     * @Param [id]
     * @return com.drugstore.bean.ReturnInfo
     **/

    @Override
    public ReturnInfo getReturnInfo(String id) {
        Connection conn = null;
        ReturnInfo returnInfo = null;

        try {
            conn = JDBCUtils.getConnection();
            ReturnInfoDAO dao = DAOSingleton.getReturnInfoDAO();
            returnInfo = dao.getByID(conn,Integer.parseInt(id));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return returnInfo;
    }

    /**
     * @MethodName getStorageEntryInfo
     * @Author 周万宁
     * @Description 根据id获取销售信息的实例
     * @Date 22:52 2022/12/4
     * @Param [id]
     * @return com.drugstore.bean.StorageEntryInfo
     **/
    @Override
    public StorageEntryInfo getStorageEntryInfo(String id) {
        Connection conn = null;
        StorageEntryInfo storageEntryInfo = null;

        try {
            conn = JDBCUtils.getConnection();
            StorageEntryInfoDAO dao = DAOSingleton.getStorageEntryInfoDAO();
            storageEntryInfo = dao.getByID(conn,Integer.parseInt(id));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return storageEntryInfo;
    }

    /**
     * @MethodName getSupplierInfo
     * @Author 周万宁
     * @Description 根据id获取供应商实例
     * @Date 22:59 2022/12/4
     * @Param [id]
     * @return com.drugstore.bean.SupplierInfo
     **/

    @Override
    public SupplierInfo getSupplierInfo(String id) {
        Connection conn = null;
        SupplierInfo supplierInfo = null;

        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            supplierInfo = dao.getByID(conn,Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return supplierInfo;
    }


}
