package com.drugstore.service.impl;

/**
 * @author 周万宁
 * @className UpdateService
 * @create 2022/12/3-15:44
 * @description 更改服务接口
 */
public interface UpdateService {
    /**
     * @MethodName updateCustomerInfo
     * @Author 周万宁
     * @Description 根据电话号码更改顾客信息
     * @Date 17:05 2022/12/3
     * @Param [name, phone]
     * @return boolean
     **/
    boolean updateCustomerInfo(String name,String phone);
    /**
     * @MethodName updateDrugInfo
     * @Author 周万宁
     * @Description 修改药品信息
     * @Date 17:08 2022/12/3
     * @Param [drugID, name, supplierID, batchNumber, placeOfOrigion, categoryOfOwnership, purchasingPrice, unitPrice, inventory, dateOfProduction, dateOfExpiry]
     * @return boolean
     **/
    boolean updateDrugInfo(String drugID,String name,String supplierID,String batchNumber,String placeOfOrigion,String categoryOfOwnership,String purchasingPrice,String unitPrice,String inventory,String dateOfProduction,String dateOfExpiry);

    /**
     * @MethodName updateEmployeesInfoDAO
     * @Author 周万宁
     * @Description 修改员工信息,部分参数需要转型
     * @Date 17:11 2022/12/3
     * @Param [employeesID, name, password, position, phone]
     * @return boolean
     **/
    boolean updateEmployeesInfoDAO(String employeesID,String name,String password,String position,String phone);

}
