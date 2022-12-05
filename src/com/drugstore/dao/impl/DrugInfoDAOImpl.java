package com.drugstore.dao.impl;

import com.drugstore.bean.DrugInfo;
import com.drugstore.dao.BaseDAO;
import com.drugstore.dao.DrugInfoDAO;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className DrugInfoDAOImpl
 * @create 2022/12/2-20:19
 * @description 药品信息表操作实现
 */
public class DrugInfoDAOImpl extends BaseDAO<DrugInfo> implements DrugInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 添加一条药品信息
     * @Date 20:32 2022/12/2
     * @Param [conn, drug]
     * @return int
     **/
    @Override
    public int insert(Connection conn, DrugInfo drug) {

        String sql ="insert into druginfo (name,supplierID,batchNumber,placeOfOrigion,categoryOfOwnership,purchasingPrice,unitPrice,inventory,dateOfProduction,dateOfExpiry) values(?,?,?,?,?,?,?,?,?,?)";
        int num = update(conn,sql,drug.getName(),drug.getSupplierID(),drug.getBatchNumber(),drug.getPlaceOfOrigion(),drug.getCategoryOfOwnership(),drug.getPurchasingPrice(),drug.getInventory(),drug.getDateOfProduction(),drug.getDateOfExpiry());
        return num;
    }

    /**
     * @MethodName update
     * @Author 周万宁
     * @Description 根据药品ID修改药品单价
     * @Date 20:33 2022/12/2
     * @Param [conn, drug]
     * @return int
     **/
    @Override
    public int update(Connection conn, DrugInfo drug) {
        String sql ="update druginfo set unitPrice = ?  where drugID = ? ";
        int num = update(conn,sql,drug.getUnitPrice(),drug.getDrugID());
        return num;
    }

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据ID查询药品
     * @Date 20:43 2022/12/2
     * @Param [conn, id]
     * @return com.drugstore.bean.DrugInfo
     **/
    @Override
    public  List<DrugInfo> getByID(Connection conn, String id) {
        String sql = "select * from druginfo where drugID = ?";
        List<DrugInfo> forList = getForList(conn, sql, id);
        return forList;
    }
    /**
     * @MethodName getByName
     * @Author 周万宁
     * @Description 根据药品名称查询药品
     * @Date 20:51 2022/12/2
     * @Param [conn, name]
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/

    @Override
    public List<DrugInfo> getByName(Connection conn, String name) {
        String sql = "select * from druginfo  where name = ?";
        List<DrugInfo> forList = getForList(conn, sql, name);
        return forList;
    }
    /**
     * @MethodName getByCategoryOfOwnership
     * @Author 周万宁
     * @Description 根据药品类别查询药品
     * @Date 20:52 2022/12/2
     * @Param [conn, categoryOfOwnership]
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/

    @Override
    public List<DrugInfo> getByCategoryOfOwnership(Connection conn, String categoryOfOwnership) {
        String sql = "select * from druginfo  where categoryOfOwnership = ?";
        List<DrugInfo> forList = getForList(conn, sql, categoryOfOwnership);
        return forList;
    }

    /**
     * @MethodName getAllDrug
     * @Author 周万宁
     * @Description 获取所有药品用于展示
     * @Date 20:52 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/
    @Override
    public List<DrugInfo> getAllDrug(Connection conn) {
        String sql = "select * from druginfo  ";
        List<DrugInfo> forList = getForList(conn, sql);
        return forList;
    }

    /**
     * @MethodName DeleteByIDAndBatch
     * @Author 周万宁
     * @Description 根据ID以及药品批次号删除药品
     * @Date 20:53 2022/12/2
     * @Param [conn, ID, batchNumber]
     * @return int
     **/
    @Override
    public int DeleteByIDAndBatch(Connection conn, String ID, String batchNumber) {
        String sql="delete from druginfo  where drugID = ? and batchNumber = ? ";
        int num = update(conn,sql,ID,batchNumber);
        return num;
    }

}
