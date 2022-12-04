package com.drugstore.dao;

import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.EmployeesInfo;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className employeesInfo
 * @create 2022/12/2-15:54
 * @description 工信息操作
 */
public interface EmployeesInfoDAO {

    /**
     * @MethodName insert
     * @Author 周万宁
     * @Description 添加员工
     * @Date 16:01 2022/12/2
     * @Param [conn, empl]
     * @return int
     **/
    int insert(Connection conn, EmployeesInfo empl);

   /**
    * @MethodName update
    * @Author 周万宁
    * @Description 根据员工ID修改员工信息
    * @Date 16:03 2022/12/2
    * @Param [conn, empl]
    * @return int
    **/
    int update(Connection conn,EmployeesInfo empl);

    /**
     * @MethodName getByID
     * @Author 周万宁
     * @Description 根据员工ID获取员工实例
     * @Date 16:14 2022/12/2
     * @Param [connection, id]
     * @return int
     **/
    EmployeesInfo getByID(Connection conn,String id);

    /**
     * @MethodName getAllEmpl
     * @Author 周万宁
     * @Description 获取所有员工信息,用于在经历页面展示员工信息
     * @Date 16:15 2022/12/2
     * @Param [connection]
     * @return java.util.List<com.drugstore.dao.EmployeesInfo>
     **/
    List<EmployeesInfo> getAllEmpl(Connection conn);


    /**
     * @MethodName deleteByID
     * @Author 周万宁
     * @Description 根据员工ID删除员工信息
     * @Date 16:18 2022/12/2
     * @Param [conn, id]
     * @return int
     **/
    int deleteByID(Connection conn,int id);

    /**
     * @MethodName getByIDAndPassword
     * @Author 周万宁
     * @Description 根据id和密码获取员工,用于验证员工用户是否存在
     * @Date 16:21 2022/12/2
     * @Param [conn, id, password]
     * @return int
     **/
    EmployeesInfo getByIDAndPassword(Connection conn,String id,String password);






}
