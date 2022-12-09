package com.drugstore.dao;

import com.drugstore.bean.CustomerInfo;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className CustomerInfoDAO
 * @create 2022/12/1-20:24
 * @description 用户信息表的DAO操作
 */
public interface CustomerInfoDAO {

  /**
   * @MethodName insert
   * @Author 周万宁
   * @Description 添加顾客
   * @Date 15:45 2022/12/2
   * @Param [conn, cust]
   * @return int
   **/
    int insert(Connection conn, CustomerInfo cust);
    /**
     * @MethodName deleteByPhone
     * @Author 卢明德
     * @Description 根据顾客电话删除顾客信息
     * @Date 15:46 2022/12/2
     * @Param [conn, phone]
     * @return int
     **/
    int deleteByPhone(Connection conn,String phone);
    /**
     * @MethodName updateByPhone
     * @Author 周万宁
     * @Description 根据电话号码更改顾客信息
     * @Date 15:46 2022/12/2
     * @Param [conn, cust]
     * @return int
     **/
    int updateByPhone(Connection conn,CustomerInfo cust);
    /**
     * @MethodName getByPhone
     * @Author 周万宁
     * @Description 根据电话号码获取用户实例
     * @Date 15:51 2022/12/2
     * @Param [conn, phone]
     * @return com.drugstore.bean.CustomerInfo
     **/
    CustomerInfo getByPhone(Connection conn,String phone);

    /**
     * @MethodName getAllCust
     * @Author 董超群
     * @Description 获取所有的顾客信息用于展示
     * @Date 18:11 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.CustomerInfo>
     **/
    List<CustomerInfo> getAllCust(Connection conn);

    /**
     * @MethodName getAllCustWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索客户信息
     * @Date 11:29 2022/12/9
     * @Param [conn, incompleteName, incompletePhone]
     * @return java.util.List<com.drugstore.bean.CustomerInfo>
     **/

    List<CustomerInfo> getAllCustWithFuzzySearch(Connection conn, String incompleteName, String incompletePhone);

}
