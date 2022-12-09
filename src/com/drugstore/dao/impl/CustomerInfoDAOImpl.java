package com.drugstore.dao.impl;

import com.drugstore.bean.CustomerInfo;
import com.drugstore.dao.BaseDAO;
import com.drugstore.dao.CustomerInfoDAO;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className CustomerInfoDAOImpl
 * @create 2022/12/2-18:28
 * @description 客户信息表操作实现
 */
public class CustomerInfoDAOImpl extends BaseDAO<CustomerInfo> implements CustomerInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 向表中增加一条顾客信息,返回影响数据的条数,如果条数为0,则增加失败, >0增加成功
     * @Date 20:03 2022/12/2
     * @Param [conn, cust]
     * @return int
     **/

    @Override
    public int insert(Connection conn, CustomerInfo cust) {

        String sql ="insert into customerinfo (customerID,name,phone) values(?,?,?)";
        int num = update(conn,sql,cust.getCustomerID(),cust.getName(),cust.getPhone());
        return num;
    } 
    
    /**
     * @MethodName deleteByPhone
     * @Author 卢明德
     * @Description 删除一条数据,返回影响数据的条数,如果条数为0,则删除失败, >0删除成功
     * @Date 20:04 2022/12/2
     * @Param [conn, phone]
     * @return int
     **/
    @Override
    public int deleteByPhone(Connection conn, String phone) {
        String sql="delete from customerinfo where phone = ?";
        int num = update(conn,sql,phone);
        return num;
    }
    /**
     * @MethodName updateByPhone
     * @Author 周万宁
     * @Description 根据电话更改顾客信息
     * @Date 20:07 2022/12/2
     * @Param [conn, cust]
     * @return int
     **/

    @Override
    public int updateByPhone(Connection conn, CustomerInfo cust) {
        String sql ="update customerinfo set name = ?  where phone = ? ";
        int num = update(conn,sql,cust.getName(),cust.getPhone());
        return num;
    }


    /**
     * @MethodName getByPhone
     * @Author 周万宁
     * @Description 根据顾客电话获取一条顾客实例,如果查询失败返回为null
     * @Date 20:14 2022/12/2
     * @Param [conn, phone]
     * @return com.drugstore.bean.CustomerInfo
     **/
    @Override
    public CustomerInfo getByPhone(Connection conn, String phone) {
        String sql = "select * from customerinfo where phone = ?";
        CustomerInfo cust = getInstance(conn,sql,phone);
        return cust;
    }

    /**
     * @MethodName getAllCust
     * @Author 董超群
     * @Description 返回所有用户信息,用于显示
     * @Date 20:16 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.CustomerInfo>
     **/
    @Override
    public List<CustomerInfo> getAllCust(Connection conn) {
        String sql = "select * from customerinfo";
        //getForList会获取列表实例
        List<CustomerInfo> forList = getForList(conn, sql);
        //将查询到的结果返回
        return forList;
    }

    /**
     * @MethodName getAllCustWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索用户信息
     * @Date 12:35 2022/12/9
     * @Param [conn, incompleteName, incompletePhone]
     * @return java.util.List<com.drugstore.bean.CustomerInfo>
     **/
    @Override
    public List<CustomerInfo> getAllCustWithFuzzySearch(Connection conn, String incompleteName, String incompletePhone) {
        String sql = "select * from customerinfo where name like \'" + "%" + incompleteName + "%" + "\'" + "or phone like \'" + "%" + incompletePhone + "%" + "\'";
        List<CustomerInfo> forList = getForList(conn, sql);
        return forList;
    }
}
