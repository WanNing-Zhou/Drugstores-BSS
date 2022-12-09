package com.drugstore.dao.impl;

import com.drugstore.bean.MarketingInfo;
import com.drugstore.bean.OutboundInfo;
import com.drugstore.bean.ReturnInfo;
import com.drugstore.dao.BaseDAO;
import com.drugstore.dao.OutboundInfoDAO;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className OutboundInfoDAOImpl
 * @create 2022/12/2-21:37
 * @description 出库信息表操作实现
 */
public class OutboundInfoDAOImpl extends BaseDAO<OutboundInfo> implements OutboundInfoDAO {


    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 新增出库信息
     * @Date 12:44 2022/12/9
     * @Param [conn, outboundInfo]
     * @return int
     **/

    @Override
    public int insert(Connection conn, OutboundInfo outboundInfo) {
        String sql ="insert into outboundinfo (drugID,drugName,purchasingPrice,number,amount,supplierID,time) values(?,?,?,?,?,?,?)";
        int num = update(conn,sql,outboundInfo.getDrugID(),outboundInfo.getDrugName(),outboundInfo.getPurchasingPrice(),outboundInfo.getNumber(),outboundInfo.getAmount(),outboundInfo.getSupplierID(),outboundInfo.getTime());
        return num;
    }
    /**
     * @MethodName upDate
     * @Author 周万宁
     * @Description 默认不能修改
     * @Date 21:38 2022/12/2
     * @Param [conn, outboundInfo]
     * @return int
     **/

    @Override
    public int upDate(Connection conn, OutboundInfo outboundInfo) {
        return 0;
    }

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据ID获取一条出库信息实例
     * @Date 21:45 2022/12/2
     * @Param [conn, id]
     * @return com.drugstore.bean.OutboundInfo
     **/
    @Override
    public OutboundInfo getByID(Connection conn, int id) {
        String sql = "select * from  outboundinfo where outboundID = ?";
        OutboundInfo instance = getInstance(conn, sql, id);
        return instance;
    }

    /**
     * @MethodName getTheLastListNumber
     * @Author 卢明德
     * @Description 获取出库信息最后一条id
     * @Date 12:45 2022/12/9
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

    /**
     * @MethodName getALLObi
     * @Author 董超群
     * @Description 获取所有出库信息,用来展示
     * @Date 21:45 2022/12/2
     * @Param [connection]
     * @return java.util.List<com.drugstore.bean.OutboundInfo>
     **/

    @Override
    public List<OutboundInfo> getALLObi(Connection connection) {
        String sql = "select * from outboundinfo";
        List<OutboundInfo> forList = getForList(connection, sql);
        return forList;
    }

    /**
     * @MethodName getALLObiWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索出库信息
     * @Date 12:45 2022/12/9
     * @Param [conn, incompleteName, supplierID]
     * @return java.util.List<com.drugstore.bean.OutboundInfo>
     **/
    @Override
    public List<OutboundInfo> getALLObiWithFuzzySearch(Connection conn, String incompleteName, int supplierID) {
        String sql = "select * from outboundinfo where drugName like \'" + "%" + incompleteName + "%" + "\'" + "or supplierID like \'" + "%" + supplierID + "%" + "\'";
        List<OutboundInfo> forList = getForList(conn, sql);
        return forList;
    }
}
