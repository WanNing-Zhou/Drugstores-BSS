package com.drugstore.dao.impl;

import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.FinancialRevenueAndExpenditureInfo;
import com.drugstore.dao.BaseDAO;
import com.drugstore.dao.FinancialRevenueAndExpenditureInfoDAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className FinancialRevenueAndExpenditureInfoDAOImpl
 * @create 2022/12/2-21:16
 * @description 财政收支信息表操作实现
 */
public class FinancialRevenueAndExpenditureInfoDAOImpl extends BaseDAO<FinancialRevenueAndExpenditureInfo> implements FinancialRevenueAndExpenditureInfoDAO {
    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 添加一条财政收支记录
     * @Date 21:22 2022/12/2
     * @Param [conn, fre]
     * @return int
     **/

    @Override
    public int insert(Connection conn, FinancialRevenueAndExpenditureInfo fre) {
        String sql ="insert into financialrevenueandexpenditureinfo (billID,typeOfBill,profitAndLoss,currentAmount,time) values(?,?,?,?,?)";
        int num = update(conn,sql,fre.getBillID(),fre.getTypeOfBill(),fre.getProfitAndLoss(),fre.getCurrentAmount(),fre.getTime());
        return num;
    }
    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据财政收支表ID获取一条实例
     * @Date 21:22 2022/12/2
     * @Param [conn, ID]
     * @return com.drugstore.bean.FinancialRevenueAndExpenditureInfo
     **/

    @Override
    public FinancialRevenueAndExpenditureInfo getByID(Connection conn, int ID) {
        String sql = "select * from financialrevenueandexpenditureinfo where financialRevenueAndExpenditureID = ?";
        FinancialRevenueAndExpenditureInfo instance = getInstance(conn, sql, ID);
        return instance;
    }

    /**
     * @MethodName getAllFre
     * @Author 周万宁
     * @Description 获取所有财政收支记录,用于展示
     * @Date 21:23 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.FinancialRevenueAndExpenditureInfo>
     **/
    @Override
    public List<FinancialRevenueAndExpenditureInfo> getAllFre(Connection conn) {
        String sql = "select * from financialrevenueandexpenditureinfo";
        List<FinancialRevenueAndExpenditureInfo> forList = getForList(conn, sql);
        return forList;
    }

    @Override
    public BigDecimal getTheLastCurrentAmount(Connection conn) {
        String sql = "select * from financialrevenueandexpenditureinfo";
        BigDecimal newlyCurrentAmount = getForLastListCurrentAmount(conn, sql);
        return newlyCurrentAmount;
    }


}
