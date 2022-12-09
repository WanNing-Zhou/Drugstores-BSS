package com.drugstore.dao.impl;

import com.drugstore.bean.FinancialRevenueAndExpenditureInfo;
import com.drugstore.bean.MarketingInfo;
import com.drugstore.dao.BaseDAO;
import com.drugstore.dao.MarketingInfoDAO;

import javax.xml.validation.Validator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author 周万宁
 * @className MarketingInfoDAOImpl
 * @create 2022/12/2-21:25
 * @description 销售信息表操作实现
 */
public class MarketingInfoDAOImpl extends BaseDAO<MarketingInfo> implements MarketingInfoDAO {
    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 添加一条销售表数据
     * @Date 21:26 2022/12/2
     * @Param [conn, mkt]
     * @return int
     **/
    @Override
    public int insert(Connection conn, MarketingInfo mkt) {
        String sql ="insert into marketinginfo (drugID,drugName,unitPrice,number, amount,customerID,time) values(?,?,?,?,?,?,?)";
        int num = update(conn,sql,mkt.getDrugID(),mkt.getDrugName(),mkt.getUnitPrice(),mkt.getNumber(),mkt.getAmount(),mkt.getCustomerID(),mkt.getTime());

        return num;
    }

    /**
     * @MethodName update
     * @Author 周万宁
     * @Description 销售信息表默认不能修改
     * @Date 21:32 2022/12/2
     * @Param [conn, mtk]
     * @return int
     **/
    @Override
    public int update(Connection conn, MarketingInfo mtk) {
        return 0;
    }

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据ID获取一个实例
     * @Date 21:32 2022/12/2
     * @Param [conn, id]
     * @return com.drugstore.bean.MarketingInfo
     **/
    @Override
    public MarketingInfo getByID(Connection conn, int id) {
        String sql = "select * from  marketinginfo where marketingID = ?";
        MarketingInfo instance = getInstance(conn, sql, id);
        return instance;
    }

    /**
     * @MethodName getTheLastListNumber
     * @Author 卢明德
     * @Description  获取销售信息最后一条ID
     * @Date 12:39 2022/12/9
     * @Param [conn]
     * @return int
     **/
    @Override
    public int getTheLastListNumber(Connection conn) {
        int num = 0;
        String sql = "select * from marketinginfo";
        num = getForLastListNumber(conn, sql);
        return num;
    }

    /**
     * @MethodName getAllMkt
     * @Author 董超群
     * @Description 获取所有销售信息表用于展示
     * @Date 21:35 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.MarketingInfo>
     **/

    @Override
    public List<MarketingInfo> getAllMkt(Connection conn) {
        String sql = "select * from marketinginfo";
        List<MarketingInfo> forList = getForList(conn, sql);
        return forList;
    }

    /**
     * @MethodName getAllMktWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索销售信息
     * @Date 12:43 2022/12/9
     * @Param [conn, incompleteName, customerID]
     * @return java.util.List<com.drugstore.bean.MarketingInfo>
     **/
    @Override
    public List<MarketingInfo> getAllMktWithFuzzySearch(Connection conn, String incompleteName, int customerID) {
        String sql = "select * from marketinginfo where drugName like \'" + "%" + incompleteName + "%" + "\'" + "or customerID like \'" + "%" + customerID + "%" + "\'";
        List<MarketingInfo> forList = getForList(conn, sql);
        return forList;
    }
}
