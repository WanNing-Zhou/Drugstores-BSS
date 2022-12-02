package com.drugstore.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * author 周万宁
 * className JDBCUtils
 * create 2022/12/1-19:57
 * description JDBC工具类
 */
public class JDBCUtils {

    public static void closeResource(Connection conn, Statement ps){
        try{
            if(ps != null)
                ps.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(conn != null)
                conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }


    public static void closeResource(Connection conn, Statement ps, ResultSet r){
        try{
            if(ps != null)
                ps.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(conn != null)
                conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        try{
            if(r!=null){
                r.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static DruidDataSource dataSource;
    static {


        try {
            Properties properties = new Properties();
            //读取jsbc.properties属性配置文件
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中添加数据
            properties.load(is);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //如果返回null说明获取联连接失败
    public  static Connection getConnection()throws Exception{

        Connection conn=null;

            conn= dataSource.getConnection();

        return conn;

    }


}
