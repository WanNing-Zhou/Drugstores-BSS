package com.drugstore.dao;

import com.drugstore.bean.OutboundInfo;
import com.drugstore.bean.ReturnInfo;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className OutboundInfoDAO
 * @create 2022/12/2-17:53
 * @description 出库信息表操作
 */
public interface OutboundInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 添加一条入库信息
     * @Date 17:54 2022/12/2
     * @Param [conn, outboundInfo]
     * @return int
     **/
    int insert(Connection conn, OutboundInfo outboundInfo);

    /**
     * @MethodName upDate
     * @Author 周万宁
     * @Description 根据入库ID修改入库信息
     * @Date 17:55 2022/12/2
     * @Param [conn, outboundInfo]
     * @return int
     **/
    int upDate(Connection conn,OutboundInfo outboundInfo);

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据ID获取入库信息
     * @Date 17:56 2022/122
     * @Param [conn, id]
     * @return com.drugstore.bean.OutboundInfo
     **/
    OutboundInfo getByID(Connection conn,int id);
    /**
     * @MethodName getTheLastListNumber
     * @Author 卢明德
     * @Description 获取出库表单的最后一个ID
     * @Date 11:33 2022/12/9
     * @Param [conn]
     * @return int
     **/
    int getTheLastListNumber(Connection conn);
    /**
     * @MethodName getALLObi
     * @Author 董超群
     * @Description 获取所有的出库信息用于展示
     * @Date 17:56 2022/12/2
     * @Param [connection]
     * @return java.util.List<com.drugstore.bean.OutboundInfo>
     **/
    List<OutboundInfo> getALLObi(Connection connection);

    /**
     * @MethodName getALLObiWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索出库信息
     * @Date 11:34 2022/12/9
     * @Param [conn, incompleteName, supplierID]
     * @return java.util.List<com.drugstore.bean.OutboundInfo>
     **/
    List<OutboundInfo> getALLObiWithFuzzySearch(Connection conn, String incompleteName, int supplierID);

}
