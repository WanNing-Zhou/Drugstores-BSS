package com.drugstore.dao;

import com.drugstore.bean.DrugInfo;
import com.drugstore.bean.MarketingInfo;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className MarketingInfo
 * @create 2022/12/2-17:24
 * @description 销售信息表的操作
 */
public interface MarketingInfoDAO {
    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 添加销售信息
     * @Date 17:27 2022/12/2
     * @Param [conn, mkt]
     * @return int
     **/
    int insert(Connection conn, MarketingInfo mkt);

    /**
     * @MethodName update
     * @Author 周万宁
     * @Description 根据销售id修改销售信息
     * @Date 17:29 2022/12/2
     * @Param [conn, mtk]
     * @return int
     **/

    int update(Connection conn,MarketingInfo mtk);

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据销售id获取一个销售单实例
     * @Date 17:31 2022/12/2
     * @Param [conn, id]
     * @return com.drugstore.bean.MarketingInfo
     **/

    MarketingInfo getByID(Connection conn,int id);



    /**
     * @MethodName getAllMkt
     * @Author 周万宁
     * @Description 获取所有销售信息,用于展示
     * @Date 17:34 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.MarketingInfo>
     **/
    List<MarketingInfo> getAllMkt(Connection conn);



}
