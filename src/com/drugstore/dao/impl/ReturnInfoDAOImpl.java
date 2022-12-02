package com.drugstore.dao.impl;

import com.drugstore.bean.MarketingInfo;
import com.drugstore.bean.ReturnInfo;
import com.drugstore.dao.BaseDAO;
import com.drugstore.dao.ReturnInfoDAO;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className ReturnInfoDAOImpl
 * @create 2022/12/2-21:46
 * @description 退货信息表操作实现
 */
public class ReturnInfoDAOImpl extends BaseDAO<ReturnInfo> implements ReturnInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 向表中添加一条退货信息
     * @Date 21:53 2022/12/2
     * @Param [conn, returnInfo]
     * @return int
     **/
    @Override
    public int insert(Connection conn, ReturnInfo returnInfo) {
        String sql ="insert into returninfo (drugID,drugName,unitPrice,number,amount,customerID,time) values(?,?,?,?,?,?,?)";
        int num = update(conn,sql,returnInfo.getDrugID(),returnInfo.getDrugName(),returnInfo.getUnitPrice(),returnInfo.getNumber(),returnInfo.getAmount(),returnInfo.getCustomerId(),returnInfo.getTime());
        return num;
    }

    /**
     * @MethodName update
     * @Author 周万宁
     * @Description 默认不能修改退货信息
     * @Date 21:48 2022/12/2
     * @Param [conn, returnInfo]
     * @return int
     **/
    @Override
    public int update(Connection conn, ReturnInfo returnInfo) {
        return 0;
    }

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据ID获得退货信息实例
     * @Date 21:54 2022/12/2
     * @Param [conn, id]
     * @return com.drugstore.bean.ReturnInfo
     **/
    @Override
    public ReturnInfo getByID(Connection conn, String id) {
        String sql = "select * from  returninfo where returnID = ?";
        ReturnInfo instance = getInstance(conn, sql, id);
        return instance;
    }

    /**
     * @MethodName getAllRet
     * @Author 周万宁
     * @Description 获取所有退货信息,用于展示
     * @Date 21:54 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.ReturnInfo>
     **/
    @Override
    public List<ReturnInfo> getAllRet(Connection conn) {
        String sql = "select * from returninfo";
        List<ReturnInfo> forList = getForList(conn, sql);
        return forList;
    }
}
