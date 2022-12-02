package com.drugstore.dao;

import com.drugstore.bean.DrugInfo;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className DrugInfoDAO
 * @create 2022/12/2-14:22
 * @description 药品信息表操作
 */
public interface DrugInfoDAO {

    /**
     * @Author 周万宁
     * @Description 添加药品信息
     * @Date 14:43 2022/12/2
     * @Param [conn, drug]
     * @return int
     **/
    int insert(Connection conn, DrugInfo drug);

    /**
     * @Author 周万宁
     * @Description 根据药品ID更改数据
     * @Date 15:41 2022/12/2
     * @Param [conn, drug]
     * @return int
     **/
    int update(Connection conn,DrugInfo drug);

    /**
     * @Author 周万宁
     * @Description 根据ID获取药品实例
     * @Date 15:42 2022/12/2
     * @Param [conn, id]
     * @return DrugInfo
     **/
    DrugInfo getByID(Connection conn,String id);

    /**
     * @Author 周万宁
     * @Description 根据药品名称获取药品
     * @Date 15:43 2022/12/2
     * @Param [conn, name]
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/
    List<DrugInfo> getByName(Connection conn, String name);

    /**
     * @Author 周万宁
     * @Description 根据药品类别获取药品
     * @Date 15:43 2022/12/2
     * @Param [conn, categoryOfOwnership]
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/
    List<DrugInfo> getByCategoryOfOwnership(Connection conn,String categoryOfOwnership);

    /**
     * @MethodName getAllDrug
     * @Author 周万宁
     * @Description 获取所有药品信息
     * @Date 16:16 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/
    List<DrugInfo> getAllDrug(Connection conn);


    /**
     * @MethodName DeleteByIDAndBatch
     * @Author 周万宁
     * @Description 根据ID与批次号删除药品信息
     * @Date 18:09 2022/12/2
     * @Param [conn, ID, batchNumber]
     * @return int
     **/
    int DeleteByIDAndBatch(Connection conn,String ID,String batchNumber);


}
