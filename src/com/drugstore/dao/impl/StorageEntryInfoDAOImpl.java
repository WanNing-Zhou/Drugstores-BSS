package com.drugstore.dao.impl;

import com.drugstore.bean.MarketingInfo;
import com.drugstore.bean.StorageEntryInfo;
import com.drugstore.dao.BaseDAO;
import com.drugstore.dao.StorageEntryInfoDAO;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className StorageEntryInfoDAOImpl
 * @create 2022/12/2-21:56
 * @description 入库信息表操作实现
 */
public class StorageEntryInfoDAOImpl extends BaseDAO<StorageEntryInfo> implements StorageEntryInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 添加一条入库信息到表中
     * @Date 22:04 2022/12/2
     * @Param [conn, storageEntryInfo]
     * @return int
     **/
    @Override
    public int insert(Connection conn, StorageEntryInfo storageEntryInfo) {

        String sql ="insert into storageentryinfo (drugID,drugName,purchasingPrice,number,amount,supplierID,time) values(?,?,?,?,?,?,?)";
        int num = update(conn,sql,storageEntryInfo.getDrugID(),storageEntryInfo.getDrugName(),storageEntryInfo.getPurchasingPrice(),storageEntryInfo.getNumber(),storageEntryInfo.getAmount(),storageEntryInfo.getSupplierID(),storageEntryInfo.getTime());
        return num;
    }

    /**
     * @MethodName update
     * @Author 周万宁
     * @Description 默认不可修改
     * @Date 22:02 2022/12/2
     * @Param [conn, storageEntryInfo]
     * @return int
     **/
    @Override
    public int update(Connection conn, StorageEntryInfo storageEntryInfo) {
        return 0;
    }
    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据id获取一条入库信息实例
     * @Date 22:04 2022/12/2
     * @Param [conn, id]
     * @return com.drugstore.bean.StorageEntryInfo
     **/

    @Override
    public StorageEntryInfo getByID(Connection conn, int id) {
        String sql = "select * from  storageentryinfo where supplierID = ?";
        StorageEntryInfo instance = getInstance(conn, sql, id);
        return instance;
    }

    /**
     * @MethodName getAllSte
     * @Author 董超群
     * @Description 获取所有入库信息用于展示
     * @Date 22:07 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.StorageEntryInfo>
     **/
    @Override
    public List<StorageEntryInfo> getAllSte(Connection conn) {
        String sql = "select * from storageentryinfo ";
        List<StorageEntryInfo> forList = getForList(conn, sql);
        return forList;
    }

    /**
     * @MethodName getAllSteWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索入库西信息
     * @Date 12:52 2022/12/9
     * @Param [conn, incompleteName, supplierID]
     * @return java.util.List<com.drugstore.bean.StorageEntryInfo>
     **/
    @Override
    public List<StorageEntryInfo> getAllSteWithFuzzySearch(Connection conn, String incompleteName, int supplierID) {
        String sql = "select * from storageentryinfo where drugName like \'" + "%" + incompleteName + "%" + "\'" + "or supplierID like \'" + "%" + supplierID + "%" + "\'";
        List<StorageEntryInfo> forList = getForList(conn, sql);
        return forList;
    }

    /**
     * @MethodName getTheLastListNumber
     * @Author 卢明德
     * @Description 获取最后一条入库id
     * @Date 12:53 2022/12/9
     * @Param [conn]
     * @return int
     **/

    @Override
    public int getTheLastListNumber(Connection conn) {
        int num = 0;
        String sql = "select * from storageentryinfo";
        num = getForLastListNumber(conn, sql);
        return num;
    }
}
