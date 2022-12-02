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
    int insert(Connection conn, CustomerInfo cust);
    int deleteByPhone(Connection conn,String phone);
    int updateByPhone(Connection conn,CustomerInfo cust);
    CustomerInfo getByPhone(Connection conn,String phone);

}
