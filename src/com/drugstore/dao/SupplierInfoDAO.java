package com.drugstore.dao;

import com.drugstore.bean.SupplierInfo;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className SupplierInfoDAO
 * @create 2022/12/2-16:24
 * @description 供应商信息表操作
 */
public interface SupplierInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 添加一条供应商信息
     * @Date 18:04 2022/12/2
     * @Param [conn, supplierInfo]
     * @return int
     **/
    int insert(Connection conn, SupplierInfo supplierInfo);

    /**
     * @MethodName delete
     * @Author 周万宁
     * @Description 根据ID删除供应商信息
     * @Date 18:05 2022/12/2
     * @Param [conn, id]
     * @return int
     **/
    int delete(Connection conn,int id);

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据ID获取一条供应商信息
     * @Date 18:06 2022/12/2
     * @Param [conn, id]
     * @return com.drugstore.bean.SupplierInfo
     **/
    SupplierInfo getByID(Connection conn,int id);


    /**
     * @MethodName getAllSupplier
     * @Author 周万宁
     * @Description 获取所有供应商信息,用于展示
     * @Date 18:07 2022/12/2
     * @Param [conn]
     * @return com.drugstore.bean.SupplierInfo
     **/
    List<SupplierInfo> getAllSupplier(Connection conn);


}
