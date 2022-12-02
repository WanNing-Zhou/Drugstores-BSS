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
     * @Description TODO
     * @Date 14:43 2022/12/2
     * @Param [conn, drug]
     * @return int
     **/
    int insert(Connection conn, DrugInfo drug);
    int update(Connection conn,DrugInfo drug);
    int getByID(Connection conn,String id);
    List<DrugInfo> getByName(Connection conn, String name);



}
