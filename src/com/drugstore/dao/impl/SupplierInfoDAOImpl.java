package com.drugstore.dao.impl;

import com.drugstore.bean.MarketingInfo;
import com.drugstore.bean.SupplierInfo;
import com.drugstore.dao.BaseDAO;
import com.drugstore.dao.SupplierInfoDAO;

import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.util.List;

/**
 * @author 周万宁
 * @className SupplierInfoDAOImpl
 * @create 2022/12/2-22:06
 * @description 供应上信息表操作实现
 */
public class SupplierInfoDAOImpl extends BaseDAO<SupplierInfo> implements SupplierInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 添加一条供应商信息
     * @Date 18:04 2022/12/2
     * @Param [conn, supplierInfo]
     * @return int
     **/
    @Override
    public int insert(Connection conn, SupplierInfo supplierInfo) {
        String sql = "insert into supplierinfo (name,agent,phone,address) values(?,?,?,?)";
        int num = update(conn,sql,supplierInfo.getName(),supplierInfo.getAgent(),supplierInfo.getPhone(),supplierInfo.getAddress());
        return num;
    }

    /**
     * @MethodName update
     * @Author 周万宁
     * @Description 更改供应商信息
     * @Date 12:56 2022/12/9
     * @Param [conn, supplierInfo]
     * @return int
     **/
    @Override
    public int update(Connection conn, SupplierInfo supplierInfo) {
        String sql = "update supplierinfo set name = ? ,agent = ?,phone = ?,address = ?  where supplierID= ? ";
        int num = update(conn, sql, supplierInfo.getName(),supplierInfo.getAgent(),supplierInfo.getPhone(),supplierInfo.getAddress(), supplierInfo.getSupplierID());
        return num;
    }

    /**
     * @MethodName delete
     * @Author 卢明德
     * @Description 根据ID删除供应商信息
     * @Date 18:05 2022/12/2
     * @Param [conn, id]
     * @return int
     **/
    @Override
    public int delete(Connection conn, int id) {
        String sql = "delete from supplierinfo where supplierID = ?";
        int num = update(conn, sql, id);
        return num;
    }

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据ID获取一条供应商实例
     * @Date 22:16 2022/12/2
     * @Param [conn, id]
     * @return com.drugstore.bean.SupplierInfo
     **/
    @Override
    public SupplierInfo getByID(Connection conn, int id) {
        String sql = "select * from  supplierinfo where supplierID = ?";
        SupplierInfo instance = getInstance(conn, sql, id);
        return instance;
    }

    /**
     * @MethodName getAllSupplier
     * @Author 董超群
     * @Description 获取所有供应商实例,为了展示
     * @Date 22:17 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.SupplierInfo>
     **/
    @Override
    public List<SupplierInfo> getAllSupplier(Connection conn) {
        String sql = "select * from supplierinfo";
        List<SupplierInfo> forList = getForList(conn, sql);
        return forList;
    }

    /**
     * @MethodName getAllSupplierWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索供应商
     * @Date 12:57 2022/12/9
     * @Param [conn, incompleteName, incompleteAgent, incompletePhone, incompleteAddress]
     * @return java.util.List<com.drugstore.bean.SupplierInfo>
     **/

    public List<SupplierInfo> getAllSupplierWithFuzzySearch(Connection conn, String incompleteName, String incompleteAgent, String incompletePhone, String incompleteAddress) {
        String sql = "select * from supplierinfo where name like \'" + "%" + incompleteName + "%" + "\'" + "or agent like \'" + "%" + incompleteAgent + "%" + "\'" + "or phone like \'" + "%" + incompletePhone + "%" + "\'" + "or address like \'" + "%" + incompleteAddress + "%" + "\'";
        List<SupplierInfo> forList = getForList(conn, sql);
        return forList;
    }
}
