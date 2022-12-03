package com.drugstore.service;

import com.drugstore.bean.*;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className getInstanceService
 * @create 2022/12/3-17:24
 * @description 信息查询操作接口,用于返回实例
 */
public interface GetInstanceService {
    /**
     * @MethodName getCustomerInfo
     * @Author 周万宁
     * @Description 获取一个客户实例
     * @Date 17:30 2022/12/3
     * @Param [phone]
     * @return com.drugstore.bean.CustomerInfo
     **/
    CustomerInfo getCustomerInfo(String phone);

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据id获取一个EmployeesInfo实例
     * @Date 19:55 2022/12/3
     * @Param [id]
     * @return com.drugstore.bean.EmployeesInfo
     **/
    EmployeesInfo getEmployeesInfo(String id);

    /**
     * @MethodName getFinancialRevenueAndExpenditureInfo
     * @Author 周万宁
     * @Description 根据ID获取一个FinancialRevenueAndExpenditureInfo实例
     * @Date 19:56 2022/12/3
     * @Param [ID]
     * @return com.drugstore.bean.FinancialRevenueAndExpenditureInfo
     **/
    FinancialRevenueAndExpenditureInfo getFinancialRevenueAndExpenditureInfo( String ID);

    /**
     * @MethodName getMarketingInfo
     * @Author 周万宁
     * @Description 根据ID获取一条MarketingInfo实例
     * @Date 19:57 2022/12/3
     * @Param [id]
     * @return com.drugstore.bean.MarketingInfo
     **/
    MarketingInfo getMarketingInfo(String id);

    /**
     * @MethodName getOutboundInfo
     * @Author 周万宁
     * @Description 根据ID获取一条OutboundInfo实例
     * @Date 19:58 2022/12/3
     * @Param [id]
     * @return com.drugstore.bean.OutboundInfo
     **/
    OutboundInfo getOutboundInfo(String id);

    /**
     * @MethodName getReturnInfo
     * @Author 周万宁
     * @Description 根据id获取ReturnInfo实例
     * @Date 19:59 2022/12/3
     * @Param [id]
     * @return com.drugstore.bean.ReturnInfo
     **/
    ReturnInfo getReturnInfo (String id);

    /**
     * @MethodName getStorageEntryInfo
     * @Author 周万宁
     * @Description 根据ID获取StorageEntryInfo实例
     * @Date 20:00 2022/12/3
     * @Param [id]
     * @return com.drugstore.bean.StorageEntryInfo
     **/
    StorageEntryInfo getStorageEntryInfo(String id);


    /**
     * @MethodName getSupplierInfo
     * @Author 周万宁
     * @Description 根据ID获取SupplierInfo实例
     * @Date 20:00 2022/12/3
     * @Param [id]
     * @return com.drugstore.bean.SupplierInfo
     **/
    SupplierInfo getSupplierInfo(String id);

}
