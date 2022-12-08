package com.drugstore.service;

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
    boolean updateDrugInfo(String drugID, String unitPrice);

    /**
     * @MethodName updateEmployeesInfoDAO
     * @Author 周万宁
     * @Description 修改员工信息,部分参数需要转型
     * @Date 17:11 2022/12/3
     * @Param [employeesID, name, password, position, phone]
     * @return boolean
     **/
    boolean updateEmployeesInfoDAO(String employeesID,String name,String password,String position,String phone);

    /**
     * @MethodName updateSupplierInfoDAO
     * @Author 周万宁
     * @Description 更改供应商信息
     * @Date 15:35 2022/12/8
     * @Param [supplierID, name, agent, phone, address]
     * @return boolean
     **/

    boolean updateSupplierInfoDAO(String supplierID, String name, String agent, String phone, String address);

}
