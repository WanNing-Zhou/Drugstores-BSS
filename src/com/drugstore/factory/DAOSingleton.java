package com.drugstore.factory;

import com.drugstore.dao.*;
import com.drugstore.dao.impl.*;
import com.mysql.jdbc.StatementImpl;

/**
 * @author 周万宁
 * @className DAOSingleton
 * @create 2022/12/3-12:54
 * @description DAO单例工厂
 */
public class DAOSingleton {


    private static final CustomerInfoDAO custDAO =  new CustomerInfoDAOImpl();
    private static final DrugInfoDAO drugDAO = new DrugInfoDAOImpl();
    private static final EmployeesInfoDAO emplDAO = new EmployeesInfoDAOImpl();
    private static final FinancialRevenueAndExpenditureInfoDAO fraeDAO = new FinancialRevenueAndExpenditureInfoDAOImpl();
    private static final MarketingInfoDAO markDAO = new MarketingInfoDAOImpl();
    private static final OutboundInfoDAO outbandDAO = new OutboundInfoDAOImpl();
    private static final ReturnInfoDAO returnDAO = new ReturnInfoDAOImpl();
    private static final StorageEntryInfoDAO storEntDAO = new StorageEntryInfoDAOImpl();
    private static final SupplierInfoDAO supDAO = new SupplierInfoDAOImpl();

    /**
     * @MethodName DAOSingleton
     * @Author 周万宁
     * @Description 私有化构造方法
     * @Date 13:25 2022/12/3
     **/
    private DAOSingleton(){}

    /**
     * @MethodName getCustomerInfoDAO
     * @Author 周万宁
     * @Description 获取CustomerInfoDAO实例
     * @Date 13:27 2022/12/3
     * @Param []
     * @return com.drugstore.dao.CustomerInfoDAO
     **/
    public static CustomerInfoDAO getCustomerInfoDAO(){
        return custDAO;
    }

    /**
     * @MethodName getDrugInfoDAO
     * @Author 周万宁
     * @Description 获取DrugInfoDAO实例
     * @Date 13:29 2022/12/3
     * @Param []
     * @return com.drugstore.dao.DrugInfoDAO
     **/
    public static DrugInfoDAO getDrugInfoDAO(){
        return drugDAO;
    }
    /**
     * @MethodName getEmployeesInfoDAO
     * @Author 周万宁
     * @Description 获取EmployeesInfoDAO实例
     * @Date 13:31 2022/12/3
     * @Param []
     * @return com.drugstore.dao.EmployeesInfoDAO
     **/

    public static EmployeesInfoDAO getEmployeesInfoDAO(){
        return emplDAO;
    }

    /**
     * @MethodName getFinancialRevenueAndExpenditureInfoDAO
     * @Author 周万宁
     * @Description 获取FinancialRevenueAndExpenditureInfoDAO实例
     * @Date 13:31 2022/12/3
     * @Param []
     * @return com.drugstore.dao.FinancialRevenueAndExpenditureInfoDAO
     **/
    public static FinancialRevenueAndExpenditureInfoDAO getFinancialRevenueAndExpenditureInfoDAO(){
        return fraeDAO;
    }

    /**
     * @MethodName getMarketingInfoDAO
     * @Author 周万宁
     * @Description 获取MarketingInfoDAO实例
     * @Date 13:32 2022/12/3
     * @Param []
     * @return com.drugstore.dao.MarketingInfoDAO
     **/
    public static MarketingInfoDAO getMarketingInfoDAO(){
        return markDAO;
    }
    /**
     * @MethodName getOutboundInfoDAO
     * @Author 周万宁
     * @Description 获取OutboundInfoDAO实例
     * @Date 13:33 2022/12/3
     * @Param []
     * @return com.drugstore.dao.OutboundInfoDAO
     **/

    public static OutboundInfoDAO getOutboundInfoDAO(){
        return outbandDAO;
    }
    /**
     * @MethodName getReturnInfoDAO
     * @Author 周万宁
     * @Description 获取ReturnInfoDAO实例
     * @Date 13:34 2022/12/3
     * @Param []
     * @return com.drugstore.dao.ReturnInfoDAO
     **/
    public static ReturnInfoDAO getReturnInfoDAO(){
        return returnDAO;
    }

    /**
     * @MethodName getStorageEntryInfoDAO
     * @Author 周万宁
     * @Description 获取StorageEntryInfoDAO实例
     * @Date 13:35 2022/12/3
     * @Param []
     * @return com.drugstore.dao.StorageEntryInfoDAO
     **/
    public static StorageEntryInfoDAO getStorageEntryInfoDAO(){
        return storEntDAO;
    }

    /**
     * @MethodName getSupplierInfoDAO
     * @Author 周万宁
     * @Description 获取SupplierInfoDAO实例
     * @Date 13:36 2022/12/3
     * @Param []
     * @return com.drugstore.dao.SupplierInfoDAO
     **/
    public static SupplierInfoDAO getSupplierInfoDAO(){
        return supDAO;
    }


}
