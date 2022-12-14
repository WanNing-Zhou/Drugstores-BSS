package com.drugstore.dao.impl;

import com.drugstore.bean.EmployeesInfo;
import com.drugstore.dao.BaseDAO;
import com.drugstore.dao.EmployeesInfoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 周万宁
 * @className EmployeesInfoDAOImpl
 * @create 2022/12/2-20:46
 * @description 员工信息操作实现
 */
public class EmployeesInfoDAOImpl extends BaseDAO<EmployeesInfo> implements EmployeesInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 向表中添加一条员工信息
     * @Date 21:09 2022/12/2
     * @Param [conn, empl]
     * @return int
     **/
    @Override
    public int insert(Connection conn, EmployeesInfo empl) {
        String sql ="insert into employeesinfo (name,password,position,phone) values(?,?,?,?)";
        int num = update(conn,sql,empl.getName(),empl.getPassword(),empl.getPosition(),empl.getPhone());
        return num;
    }

    /**
     * @MethodName update
     * @Author 周万宁
     * @Description 根据id修改员工信息
     * @Date 21:09 2022/12/2
     * @Param [conn, empl]
     * @return int
     **/

    @Override
    public int update(Connection conn, EmployeesInfo empl) {
        String sql ="update employeesinfo set name = ? ,password = ?,position = ?,phone = ?  where employeesID= ? ";
        int num = update(conn,sql,empl.getName(),empl.getPassword(),empl.getPosition(),empl.getPhone(),empl.getEmployeesID());
        return num;
    }
    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据ID获取一条员工信息实例
     * @Date 21:10 2022/12/2
     * @Param [conn, id]
     * @return com.drugstore.bean.EmployeesInfo
     **/

    @Override
    public EmployeesInfo getByID(Connection conn, int id) {
        String sql = "select employeesID,name,position,phone from employeesinfo where employeesID = ?";
        EmployeesInfo instance = getInstance(conn, sql, id);
        return instance;
    }

    /**
     * @MethodName getAllEmpl
     * @Author 董超群
     * @Description 获取所有的员工信息用于展示
     * @Date 21:10 2022/12/2
     * @Param [conn]
     * @return java.util.List<com.drugstore.bean.EmployeesInfo>
     **/
    @Override
    public List<EmployeesInfo> getAllEmpl(Connection conn) {
        String sql = "select employeesID,name,position,phone from employeesinfo";
        List<EmployeesInfo> forList = getForList(conn, sql);
        return  forList;
    }

    /**
     * @MethodName getAllWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索员工信息
     * @Date 12:38 2022/12/9
     * @Param [conn, incompleteName, incompletePhone]
     * @return java.util.List<com.drugstore.bean.EmployeesInfo>
     **/
    @Override
    public List<EmployeesInfo> getAllWithFuzzySearch(Connection conn, String incompleteName, String incompletePhone) {
        String sql = "select employeesID,name,position,phone from employeesinfo where name like \'" + "%" + incompleteName + "%" + "\'" + "or phone like \'" + "%" + incompletePhone + "%" + "\'";
        List<EmployeesInfo> forList = getForList(conn, sql);
        return forList;
    }

    /**
     * @MethodName deleteByID
     * @Author 卢明德
     * @Description 根据ID删除员工信息
     * @Date 21:13 2022/12/2
     * @Param [conn, id]
     * @return int
     **/
    @Override
    public int deleteByID(Connection conn, int id) {
        String sql="delete from employeesinfo where employeesID = ?";
        System.out.println(sql);
        int num = update(conn, sql, id);
        return num;
    }



    /**
     * @MethodName getByIDAndPassword
     * @Author 李建昌
     * @Description 根据ID与Password获取员工,用来登录操作
     * @Date 21:14 2022/12/2
     * @Param [conn, id, password]
     * @return com.drugstore.bean.EmployeesInfo
     **/
    @Override
    public EmployeesInfo getByIDAndPassword(Connection conn, String id, String password) {
        //sql语句 ?占位符
        String sql = "select employeesID,name,position,phone from employeesinfo where employeesID = ? and password = ?";
        //获取一个EmployeeInfo实例
        EmployeesInfo instance = getInstance(conn, sql, id, password);
        //将实例返回
        return instance;
    }
}
