package com.drugstore.service;

import javax.lang.model.element.NestingKind;

/**
 * @author 周万宁
 * @className AddInfoService
 * @create 2022/12/3-14:07
 * @description 添加服务接口
 */
public interface AddInfoService {
    /**
     * @MethodName addCustomerInfo
     * @Author 周万宁
     * @Description 用于添加顾客信息,返回一个bool值代表是否添加成功
     * @Date 14:10 2022/12/3
     * @Param [name, phone]
     * @return boolean
     **/
    boolean addCustomerInfo(String name,String phone);
    /**
     * @MethodName addDrugInfo
     * @Author 周万宁
     * @Description 用于新增药品信息,返回一个bool值代表是否添加成功,具体实现中需要对部分数据进行类型转换,以便与数据库中的类型进行匹配
     * @Date 14:51 2022/12/3
     * @Param [drugID, name, supplierID, batchNumber, placeOfOrigion, categoryOfOwnership, purchasingPrice, unitPrice, inventory, dateOfProduction, dateOfExpiry]
     * @return boolean
     **/

    boolean addDrugInfo(String drugID,String name,String supplierID,String batchNumber,String placeOfOrigion,String categoryOfOwnership,String purchasingPrice,String unitPrice,String inventory,String dateOfProduction,String dateOfExpiry);

    /**
     * @MethodName addEmployeesInfo
     * @Author 周万宁
     * @Description 添加员工操作,返回一个bool值代表是否添加成功
     * @Date 14:54 2022/12/3
     * @Param [name, password, postion, phone]
     * @return boolean
     **/
    boolean addEmployeesInfo(String name,String password,String postion,String phone);

    /**
     * @MethodName addFinancialRevenueAndExpenditureInfo
     * @Author 周万宁
     * @Description 添加财政收支西悉尼,返回一个bool值代表是否添加成功,需要对部分参数进行转型
     * @Date 14:59 2022/12/3
     * @Param [billID, typeOfBill, profitAndLoss, currentAmount, time]
     * @return boolean
     **/
    boolean addFinancialRevenueAndExpenditureInfo(String billID, String typeOfBill, String profitAndLoss, String currentAmount, String time);

    /**
     * @MethodName addMarketingInfo
     * @Author 周万宁
     * @Description 添加销售记录,返回bool值,需要对部分参数进行转型
     * @Date 15:13 2022/12/3
     * @Param [drugID, unitPrice, number, amount, customerID, time]
     * @return boolean
     **/
    boolean addMarketingInfo(String drugID,String unitPrice,String number,String amount,String customerID,String time);

    /**
     * @MethodName addOutboundInfo
     * @Author 周万宁
     * @Description 添加出库信息,返回bool值,需要对部分参数进行转型
     * @Date 15:16 2022/12/3
     * @Param [drugID, drugName, purchasingPrice, number, amount, supplierID, time]
     * @return boolean
     **/
    boolean addOutboundInfo(String drugID,String drugName,String purchasingPrice,String number,String amount,String supplierID,String time);

    /**
     * @MethodName addOutboundInfo
     * @Author 周万宁
     * @Description 添加退货信息,返回bool值,需要对部分参数进行转型
     * @Date 15:17 2022/12/3
     * @Param [drugID, drugName, purchasingPrice, number, amount, supplierID, time]
     * @return boolean
     **/
    boolean addReturnInfo(String drugID,String drugName,String purchasingPrice,String number,String amount,String customerId,String time);

    /**
     * @MethodName addStorageEntryInfo
     * @Author 周万宁
     * @Description 添加入库信息,返回bool值,需要对部分参数进行转型
     * @Date 15:20 2022/12/3
     * @Param [drugID, drugName, purchasingPrice, number, amount, supplierID, time]
     * @return boolean
     **/
    boolean addStorageEntryInfo(String drugID,String drugName,String purchasingPrice,String number,String amount,String supplierID,String time);

    /**
     * @MethodName addSupplierInfo
     * @Author 周万宁
     * @Description 添加供应商信息,返回bool值,需要对部分参数进行转型
     * @Date 15:22 2022/12/3
     * @Param [name, agent, phone, address]
     * @return boolean
     **/
    boolean addSupplierInfo(String name,String agent,String phone,String address);


}
