package com.drugstore.dao;

import com.drugstore.bean.ReturnInfo;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className ReturnInfo
 * @create 2022/12/2-17:36
 * @description 退货信息表操作
 */
public interface ReturnInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 新增退货信息表
     * @Date 17:40 2022/12/2
     * @Param [conn, returnInfo]
     * @return int
     **/
    int insert(Connection conn, ReturnInfo returnInfo);

    /**
     * @MethodName update
     * @Author 周万宁
     * @Description 修改退货信息表
     * @Date 17:41 2022/12/2
     * @Param [conn, returnInfo]
     * @return int
     **/
    int update(Connection conn,ReturnInfo returnInfo);

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据id获取退货信息
     * @Date 17:42 2022/12/2
     * @Param [conn, id]
     * @return com.drugstore.bean.ReturnInfo
     **/
    ReturnInfo getByID(Connection conn,int id);


    /**
     * @MethodName getAllRet
     * @Author 周万宁
     * @Description 获取所有退货信息用于展示
     * @Date 17:43 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.ReturnInfo>
     **/
    List<ReturnInfo> getAllRet(Connection conn);



}
