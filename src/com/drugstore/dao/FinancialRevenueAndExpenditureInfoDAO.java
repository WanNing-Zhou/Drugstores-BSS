package com.drugstore.dao;

import com.drugstore.bean.FinancialRevenueAndExpenditureInfo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className FinancialRevenueAndExpenditureInfo
 * @create 2022/12/2-17:57
 * @description 财政收支信息表操作
 */
public interface FinancialRevenueAndExpenditureInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 添加一条财政收支信息
     * @Date 17:59 2022/12/2
     * @Param [conn, fre]
     * @return int
     **/
    int insert(Connection conn, FinancialRevenueAndExpenditureInfo fre);


    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据ID获取收支信息
     * @Date 18:02 2022/12/2
     * @Param [conn, ID]
     * @return com.drugstore.bean.FinancialRevenueAndExpenditureInfo
     **/
    FinancialRevenueAndExpenditureInfo getByID(Connection conn,int ID);

    /**
     * @MethodName getAllFre
     * @Author 董超群
     * @Description 获取所有的收支信息,用于展示
     * @Date 18:03 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.FinancialRevenueAndExpenditureInfo>
     **/
    List<FinancialRevenueAndExpenditureInfo> getAllFre(Connection conn);

    /**
     * @MethodName getTheLastCurrentAmount
     * @Author 卢明德
     * @Description 搜索最后的金额
     * @Date 11:32 2022/12/9
     * @Param [conn]
     * @return java.math.BigDecimal
     **/
    BigDecimal getTheLastCurrentAmount(Connection conn);

}
