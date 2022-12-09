package com.drugstore.service;

/**
 * @author 周万宁
 * @className DeleteService
 * @create 2022/12/3-15:25
 * @description 删除服务接口
 */
public interface DeleteService {

    /**
     * @MethodName deleteCustomerInfoDAOByPhone
     * @Author 卢明德
     * @Description 根据电话号码删除顾客信息
     * @Date 15:32 2022/12/3
     * @Param [phone]
     * @return boolean
     **/
    boolean deleteCustomerInfoByPhone(String phone);

    /**
     * @MethodName deleteDrugInfo
     * @Author 卢明德
     * @Description 根据id和批次删除药品,对应逾期药品处理操作
     * @Date 15:35 2022/12/3
     * @Param [id]
     * @return boolean
     **/
    boolean deleteDrugInfo(String id,String batchNumber);

    /**
     * @MethodName deleteEmployeesInfo
     * @Author 卢明德
     * @Description 根据id删除员工
     * @Date 15:39 2022/12/3
     * @Param [id]
     * @return boolean
     **/
    boolean deleteEmployeesInfo(String id);

    /**
     * @MethodName deleteSupplierInfo
     * @Author 卢明德
     * @Description 根据id删除供应商信息
     * @Date 15:42 2022/12/3
     * @Param [id]
     * @return boolean
     **/
    boolean deleteSupplierInfo(String id);



}
