package com.drugstore.service.impl;

import com.drugstore.bean.*;
import com.drugstore.dao.*;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.service.GetForListService;
import com.drugstore.utils.JDBCUtils;
import com.drugstore.utils.STRisINT;
import netscape.javascript.JSException;

import java.sql.Connection;
import java.util.List;

/**
 * @author 周万宁
 * @className GetForListServiceImpl
 * @create 2022/12/3-21:56
 * @description 获取多行信息服务具体实现
 */
public class GetForListServiceImpl implements GetForListService {

    /**
     * @MethodName getAllCustomerInfo
     * @Author 董超群
     * @Description 获取所有顾客
     * @Date 9:58 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.CustomerInfo>
     **/
    @Override
    public List<CustomerInfo> getAllCustomerInfo() {
        Connection conn = null;
        List<CustomerInfo> list = null;

        try {

            //获取数据库连接(会有异常)
            conn = JDBCUtils.getConnection();
            //获取dao实例
            //在单例工厂里获取
            CustomerInfoDAO dao = DAOSingleton.getCustomerInfoDAO();
            //getAllCust获取所有的客户信息
            list = dao.getAllCust(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //将数据库连接关闭
            JDBCUtils.closeResource(conn,null);
        }

        //将获取到的数据返回出去
        return list;
    }

    /**
     * @MethodName getAllCustInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索客户信息
     * @Date 11:23 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.CustomerInfo>
     **/

    public List<CustomerInfo> getAllCustInfoWithFuzzySearch(String str) {
        Connection conn = null;
        List<CustomerInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            CustomerInfoDAO dao = DAOSingleton.getCustomerInfoDAO();
            list = dao.getAllCustWithFuzzySearch(conn, str, str);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllDrugInfo
     * @Author 董超群
     * @Description 获取所有药品信息
     * @Date 10:01 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/
    @Override
    public List<DrugInfo> getAllDrugInfo() {
        Connection conn = null;
        List<DrugInfo> list = null;
        try {
            //获取数据库连接
            conn = JDBCUtils.getConnection();
            DrugInfoDAO dao = DAOSingleton.getDrugInfoDAO();
            list = dao.getAllDrug(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllDrugInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索药品信息
     * @Date 11:24 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.DrugInfo>
     **/
    @Override
    public List<DrugInfo> getAllDrugInfoWithFuzzySearch(String str) {
        Connection conn = null;
        List<DrugInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            DrugInfoDAO dao = DAOSingleton.getDrugInfoDAO();
            list = dao.getAllDrugWithFuzzySearch(conn, str, str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }


    /**
     * @MethodName getAllEmployeesInfo
     * @Author 董超群
     * @Description 获取所有员工信息
     * @Date 10:01 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.EmployeesInfo>
     **/
    @Override
    public List<EmployeesInfo> getAllEmployeesInfo() {
        Connection conn = null;
        List<EmployeesInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            list =  dao.getAllEmpl(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllEmployeesInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索员工信息
     * @Date 11:24 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.EmployeesInfo>
     **/
    @Override
    public List<EmployeesInfo> getAllEmployeesInfoWithFuzzySearch(String str) {
        Connection conn = null;
        List<EmployeesInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            list =  dao.getAllWithFuzzySearch(conn, str, str);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllFinancialRevenueAndExpenditureInfo
     * @Author 董超群
     * @Description 获取所有财政收支表单
     * @Date 10:02 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.FinancialRevenueAndExpenditureInfo>
     **/
    @Override
    public List<FinancialRevenueAndExpenditureInfo> getAllFinancialRevenueAndExpenditureInfo() {
        Connection conn = null;
        List<FinancialRevenueAndExpenditureInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            FinancialRevenueAndExpenditureInfoDAO dao = DAOSingleton.getFinancialRevenueAndExpenditureInfoDAO();
            list = dao.getAllFre(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllMarketingInfo
     * @Author 董超群
     * @Description 获取所有销售信息
     * @Date 10:04 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.MarketingInfo>
     **/
    @Override
    public List<MarketingInfo> getAllMarketingInfo() {
        Connection conn = null;
        List<MarketingInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            MarketingInfoDAO dao = DAOSingleton.getMarketingInfoDAO();
            list = dao.getAllMkt(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllMarketingInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 根据搜索内容,获取域搜索内同匹配得数据
     * @Date 19:21 2022/12/8
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.MarketingInfo>
     **/
    @Override
    public List<MarketingInfo> getAllMarketingInfoWithFuzzySearch(String str) {
        Connection conn = null;
        List<MarketingInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            MarketingInfoDAO dao = DAOSingleton.getMarketingInfoDAO();

            //这里不能转换成为int类型可以先去判断是否是数字,如果是就转换成int类型
            int cid= 0;
            if (STRisINT.isNumeric(str)){
                Integer.parseInt(str);
            }


            list = dao.getAllMktWithFuzzySearch(conn, str, cid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getALLOutboundInfo
     * @Author 董超群
     * @Description 获取所有出库信息
     * @Date 10:05 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.OutboundInfo>
     **/
    @Override
    public List<OutboundInfo> getALLOutboundInfo() {
        Connection conn = null;
        List<OutboundInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            OutboundInfoDAO dao = DAOSingleton.getOutboundInfoDAO();
            list = dao.getALLObi(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getALLOutboundInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索出库信息
     * @Date 11:25 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.OutboundInfo>
     **/
    @Override
    public List<OutboundInfo> getALLOutboundInfoWithFuzzySearch(String str) {
        Connection conn = null;
        List<OutboundInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            OutboundInfoDAO dao = DAOSingleton.getOutboundInfoDAO();
            int sid = 0;
            //判断是否是数字类型的字符串
            if(STRisINT.isNumeric(str)){
              sid  = Integer.parseInt(str);
            }

            list = dao.getALLObiWithFuzzySearch(conn, str, sid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllReturnInfo
     * @Author 董超群
     * @Description 获取所有退货信息
     * @Date 16:01 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.ReturnInfo>
     **/

    @Override
    public List<ReturnInfo> getAllReturnInfo() {

        Connection conn = null;
        List<ReturnInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            ReturnInfoDAO dao = DAOSingleton.getReturnInfoDAO();
            list = dao.getAllRet(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllReturnInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索退货信息
     * @Date 11:28 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.ReturnInfo>
     **/

    @Override
    public List<ReturnInfo> getAllReturnInfoWithFuzzySearch(String str) {
        Connection conn = null;
        List<ReturnInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            ReturnInfoDAO dao = DAOSingleton.getReturnInfoDAO();

            int cid = 0;
            //如过str是数字则转换类型
            if(STRisINT.isNumeric(str)){
                cid = Integer.parseInt(str);
            }

            list = dao.getAllRetWithFuzzySearch(conn, str, cid);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }


    /**
     * @MethodName getAllStorageEntryInfo
     * @Author 董超群
     * @Description 获取所有入库信息
     * @Date 10:06 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.StorageEntryInfo>
     **/
    @Override
    public List<StorageEntryInfo> getAllStorageEntryInfo() {
        Connection conn = null;
        List<StorageEntryInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            StorageEntryInfoDAO dao = DAOSingleton.getStorageEntryInfoDAO();
            list = dao.getAllSte(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }


    /**
     * @MethodName getAllStorageEntryInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索入库信息
     * @Date 11:28 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.StorageEntryInfo>
     **/

    @Override
    public List<StorageEntryInfo> getAllStorageEntryInfoWithFuzzySearch(String str) {
        Connection conn = null;
        List<StorageEntryInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            StorageEntryInfoDAO dao = DAOSingleton.getStorageEntryInfoDAO();

            int sid = 0;
            if(STRisINT.isNumeric(str)){
                sid  = Integer.parseInt(str);
            }

            list = dao.getAllSteWithFuzzySearch(conn, str, sid);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }

    /**
     * @MethodName getAllSupplierInfo
     * @Author 董超群
     * @Description 获取所有供应商信息
     * @Date 10:08 2022/12/5
     * @Param []
     * @return java.util.List<com.drugstore.bean.SupplierInfo>
     **/

    @Override
    public List<SupplierInfo> getAllSupplierInfo() {
        Connection conn = null;
        List<SupplierInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            list = dao.getAllSupplier(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        return list;
    }

    /**
     * @MethodName getAllSupplierInfoWithFuzzySearch
     * @Author 卢明德
     * @Description 搜索供应商信息
     * @Date 11:29 2022/12/9
     * @Param [str]
     * @return java.util.List<com.drugstore.bean.SupplierInfo>
     **/
    @Override
    public List<SupplierInfo> getAllSupplierInfoWithFuzzySearch(String str) {
        Connection conn = null;
        List<SupplierInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();
            list = dao.getAllSupplierWithFuzzySearch(conn, str, str, str, str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        return list;
    }
}
