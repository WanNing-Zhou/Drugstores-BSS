package com.drugstore.service.impl;

import com.drugstore.service.DeleteService;

/**
 * @author 周万宁
 * @className DeleteServiceImpl
 * @create 2022/12/3-21:54
 * @description 删除服务实现
 */
public class DeleteServiceImpl implements DeleteService {
    @Override
    public boolean deleteCustomerInfoByPhone(String phone) {
        return false;
    }

    @Override
    public boolean deleteDrugInfo(String id, String batchNumber) {
        return false;
    }

    @Override
    public boolean deleteEmployeesInfo(String id) {
        return false;
    }

    @Override
    public boolean deleteSupplierInfo(String id) {
        return false;
    }
}
