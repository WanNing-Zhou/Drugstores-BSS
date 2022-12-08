package com.drugstore.service;

import com.drugstore.bean.*;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className GetForListService
 * @create 2022/12/3-20:02
 * @description 获取信息列表的接口
 */
public interface GetForListService {
    /**
     * @MethodName getAllCustomerInfo
     * @Author 周万宁
     * @Description 获取所有顾客信息用于展示到页面
     * @Date 20:06 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.CustomerInfo>
     **/
    List<CustomerInfo> getAllCustomerInfo();
    List<CustomerInfo> getAllCustInfoWithFuzzySearch(String str);

    /**
     * @MethodName getAllDrugInfo
     * @Author 周万宁
     * @Description 获取所有药品信息展示到页面
     * @Date 20:07 2022/12/3
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/

    List<DrugInfo> getAllDrugInfo();

    List<DrugInfo> getAllDrugInfoWithFuzzySearch(String str);

    /**
     * @MethodName getAllEmployeesInfo
     * @Author 周万宁
     * @Description 获取所有员工信息展示到页面
     * @Date 20:11 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.EmployeesInfo>
     **/
    List<EmployeesInfo> getAllEmployeesInfo();


    List<EmployeesInfo> getAllEmployeesInfoWithFuzzySearch(String str);
    /**
     * @MethodName getAllFinancialRevenueAndExpenditureInfo
     * @Author 周万宁
     * @Description 获取所有FinancialRevenueAndExpenditureInfo用于展示
     * @Date 20:11 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.FinancialRevenueAndExpenditureInfo>
     **/

    List<FinancialRevenueAndExpenditureInfo> getAllFinancialRevenueAndExpenditureInfo();

    /**
     * @MethodName getAllMarketingInfo
     * @Author 周万宁
     * @Description 获取所有MarketingInfo用于展示
     * @Date 20:14 2022/12/3
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.MarketingInfo>
     **/
    List<MarketingInfo> getAllMarketingInfo();
    List<MarketingInfo> getAllMarketingInfoWithFuzzySearch(String str);

    /**
     * @MethodName getALLOutboundInfo
     * @Author 周万宁
     * @Description 获取所有OutboundInfo用于展示
     * @Date 20:14 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.OutboundInfo>
     **/
    List<OutboundInfo> getALLOutboundInfo();

    List<OutboundInfo> getALLOutboundInfoWithFuzzySearch(String str);

    List<ReturnInfo> getAllReturnInfo();
    List<ReturnInfo> getAllReturnInfoWithFuzzySearch(String str);

    /**
     * @MethodName getAllStorageEntryInfo
     * @Author 周万宁
     * @Description 获取所有StorageEntryInfo用于展示
     * @Date 20:15 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.StorageEntryInfo>
     **/
    List<StorageEntryInfo> getAllStorageEntryInfo();

    List<StorageEntryInfo> getAllStorageEntryInfoWithFuzzySearch(String str);
    /**
     * @MethodName getAllSupplierInfo
     * @Author 周万宁
     * @Description 获取所有SupplierInfo用于展示
     * @Date 20:16 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.SupplierInfo>
     **/
    List<SupplierInfo> getAllSupplierInfo();

    List<SupplierInfo> getAllSupplierInfoWithFuzzySearch(String str);

}
