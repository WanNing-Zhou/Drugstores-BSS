package com.drugstore.service;

import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.DrugInfo;

import java.util.List;

/**
 * @author 周万宁
 * @className getInstanceService
 * @create 2022/12/3-17:24
 * @description 信息查询操作接口,用于返回实例
 */
public interface getInstanceService {
    /**
     * @MethodName getCustomerInfo
     * @Author 周万宁
     * @Description 获取一个客户实例
     * @Date 17:30 2022/12/3
     * @Param [phone]
     * @return com.drugstore.bean.CustomerInfo
     **/
    CustomerInfo getCustomerInfo(String phone);





}
