package com.drugstore.dao;

import com.drugstore.bean.StorageEntryInfo;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className StorageEntryInfo
 * @create 2022/12/2-17:44
 * @description 入库信息表操作
 */
public interface StorageEntryInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 添加一条入库信息
     * @Date 17:48 2022/12/2
     * @Param [conn, storageEntryInfo]
     * @return int
     **/
    int insert(Connection conn, StorageEntryInfo storageEntryInfo);

    /**
     * @MethodName update
     * @Author 周万宁
     * @Description 根据入库ID更改入库信息
     * @Date 17:49 2022/12/2
     * @Param [conn, storageEntryInfo]
     * @return int
     **/
    int update(Connection conn,StorageEntryInfo storageEntryInfo);

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据入库ID查询
     * @Date 17:51 2022/12/2
     * @Param [conn, id]
     * @return com.drugstore.bean.StorageEntryInfo
     **/
    StorageEntryInfo getByID(Connection conn,int id);
    int getTheLastListNumber(Connection conn);

    /**
     * @MethodName getAllSte
     * @Author 周万宁
     * @Description 获取所有入库信息用于操作
     * @Date 17:52 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.StorageEntryInfo>
     **/
    List<StorageEntryInfo> getAllSte(Connection conn);

    List<StorageEntryInfo> getAllSteWithFuzzySearch(Connection conn, String incompleteName, int supplierID);



}
