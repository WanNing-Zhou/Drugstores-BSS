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
     * @Author 董超群
     * @Description 获取所有顾客信息用于展示到页面
     * @Date 20:06 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.CustomerInfo>
     **/
    List<CustomerInfo> getAllCustomerInfo();
    /**
     * @MethodName getAllCustInfoWithFuzzySearch
     * @Author  卢明德
     * @Description 根据字符串搜索顾客信息
     * @Date 11:13 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.CustomerInfo>
     **/
    List<CustomerInfo> getAllCustInfoWithFuzzySearch(String str);

    /**
     * @MethodName getAllDrugInfo
     * @Author 董超群
     * @Description 获取所有药品信息展示到页面
     * @Date 20:07 2022/12/3
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/

    List<DrugInfo> getAllDrugInfo();

    /**
     * @MethodName getAllDrugInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索药品信息
     * @Date 11:19 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/
    List<DrugInfo> getAllDrugInfoWithFuzzySearch(String str);

    /**
     * @MethodName getAllEmployeesInfo
     * @Author 董超群
     * @Description 获取所有员工信息展示到页面
     * @Date 20:11 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.EmployeesInfo>
     **/
    List<EmployeesInfo> getAllEmployeesInfo();

    /**
     * @MethodName getAllEmployeesInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索员工信息
     * @Date 11:19 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.EmployeesInfo>
     **/

    List<EmployeesInfo> getAllEmployeesInfoWithFuzzySearch(String str);
    /**
     * @MethodName getAllFinancialRevenueAndExpenditureInfo
     * @Author 董超群
     * @Description 获取所有FinancialRevenueAndExpenditureInfo用于展示
     * @Date 20:11 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.FinancialRevenueAndExpenditureInfo>
     **/

    List<FinancialRevenueAndExpenditureInfo> getAllFinancialRevenueAndExpenditureInfo();

    /**
     * @MethodName getAllMarketingInfo
     * @Author 董超群
     * @Description 获取所有MarketingInfo用于展示
     * @Date 20:14 2022/12/3
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.MarketingInfo>
     **/
    List<MarketingInfo> getAllMarketingInfo();
    /**
     * @MethodName getAllMarketingInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索销售信息
     * @Date 11:19 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.MarketingInfo>
     **/
    List<MarketingInfo> getAllMarketingInfoWithFuzzySearch(String str);

    /**
     * @MethodName getALLOutboundInfo
     * @Author 董超群
     * @Description 获取所有OutboundInfo用于展示
     * @Date 20:14 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.OutboundInfo>
     **/
    List<OutboundInfo> getALLOutboundInfo();

    /**
     * @MethodName getALLOutboundInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索出库信息
     * @Date 11:20 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.OutboundInfo>
     **/
    List<OutboundInfo> getALLOutboundInfoWithFuzzySearch(String str);

    /**
     * @MethodName getAllReturnInfo
     * @Author 董超群
     * @Description 获取所有退货信息
     * @Date 11:20 2022/12/9
     * @Param []
     * @return java.util.List<com.drugstore.bean.ReturnInfo>
     **/
    List<ReturnInfo> getAllReturnInfo();
    /**
     * @MethodName getAllReturnInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索退货信息
     * @Date 11:20 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.ReturnInfo>
     **/
    List<ReturnInfo> getAllReturnInfoWithFuzzySearch(String str);

    /**
     * @MethodName getAllStorageEntryInfo
     * @Author 董超群
     * @Description 获取所有StorageEntryInfo用于展示
     * @Date 20:15 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.StorageEntryInfo>
     **/
    List<StorageEntryInfo> getAllStorageEntryInfo();

    /**
     * @MethodName getAllStorageEntryInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索入库信息
     * @Date 11:21 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.StorageEntryInfo>
     **/
    List<StorageEntryInfo> getAllStorageEntryInfoWithFuzzySearch(String str);
    /**
     * @MethodName getAllSupplierInfo
     * @Author 董超群
     * @Description 获取所有SupplierInfo用于展示
     * @Date 20:16 2022/12/3
     * @Param []
     * @return java.util.List<com.drugstore.bean.SupplierInfo>
     **/
    List<SupplierInfo> getAllSupplierInfo();

    /**
     * @MethodName getAllSupplierInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索供应商信息
     * @Date 11:21 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.SupplierInfo>
     **/
    List<SupplierInfo> getAllSupplierInfoWithFuzzySearch(String str);

}
