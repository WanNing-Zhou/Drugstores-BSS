package com.drugstore.service.impl;

import com.drugstore.bean.*;
import com.drugstore.dao.*;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.service.AddInfoService;
import com.drugstore.utils.JDBCUtils;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

/**
 * @author 周万宁
 * @className AddInfoServiceImpl
 * @create 2022/12/3-20:18
 * @description 添加接口的具体实现
 */

public class AddInfoServiceImpl implements AddInfoService {

    /**
     * @MethodName addCustomerInfo
     * @Author 周万宁
     * @Description 添加顾客
     * @Date 20:28 2022/12/3
     * @Param [name, phone]
     * @return boolean
     **/
    @Override
    public boolean addCustomerInfo(String name, String phone) {

        CustomerInfoDAO customerInfoDAO=null;
        Connection conn =null;
        int num = 0;
        try {
            //获取DAO实例
            customerInfoDAO = DAOSingleton.getCustomerInfoDAO();
            //获取Connection实例
            conn = JDBCUtils.getConnection();
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setName(name);
            customerInfo.setPhone(phone);
            //返回影响数据的条数
            num = customerInfoDAO.insert(conn, customerInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        if(num>0){
            return true; //表示添加成功
        }

        return false;//添加失败
    }

    /**
     * @MethodName addDrugInfo
     * @Author 周万宁
     * @Description 添加一条药品信息,在此方法内需要对部分数据进行转型,才能使用dao内的insert方法
     * @Date 20:59 2022/12/3
     * @Param [drugID, name, supplierID, batchNumber, placeOfOrigion, categoryOfOwnership, purchasingPrice, unitPrice, inventory, dateOfProduction, dateOfExpiry]
     * @return boolean
     **/
    @Override
    public boolean addDrugInfo(String drugID, String name, String supplierID, String batchNumber, String placeOfOrigin, String categoryOfOwnership, String purchasingPrice, String unitPrice, String inventory, String dateOfProduction, String dateOfExpiry) {
        Connection conn = null;
        int num = 0;

        try {
            DrugInfoDAO drugInfoDAO = DAOSingleton.getDrugInfoDAO();
            conn = JDBCUtils.getConnection();

//            格式转换
            int sID = Integer.parseInt(supplierID);
            BigDecimal pp = new BigDecimal(purchasingPrice);
            BigDecimal up = new BigDecimal(unitPrice);
            int inv = Integer.parseInt(inventory);
            //确定日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dop = new Date(sdf.parse(dateOfProduction).getTime());
            Date doe = new Date(sdf.parse(dateOfExpiry).getTime());

            DrugInfo drug = new DrugInfo(drugID,name,sID,batchNumber,placeOfOrigin,categoryOfOwnership,pp,up,inv,dop,doe);
//            System.out.println(drug);
            num = drugInfoDAO.insert(conn,drug);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        if(num>0){
            return true;
        }
        return false;
    }

    /**
     * @MethodName addEmployeesInfo
     * @Author 周万宁
     * @Description 添加员工,部分参数需要进行转型才能使用dao中的insert操作
     * @Date 21:06 2022/12/3
     * @Param [name, password, postion, phone]
     * @return boolean
     **/

    @Override
    public boolean addEmployeesInfo(String name, String password, String postion, String phone) {
        Connection conn = null;
        int num = 0;

        try {
            EmployeesInfoDAO dao = DAOSingleton.getEmployeesInfoDAO();
            conn = JDBCUtils.getConnection();
            EmployeesInfo emp = new EmployeesInfo(name,password,postion,phone);
            num = dao.insert(conn,emp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        if(num>0){
            return true;
        }
        return false;
    }

    /**
     * @MethodName addFinancialRevenueAndExpenditureInfo
     * @Author 周万宁
     * @Description
     * @Date 21:07 2022/12/3
     * @Param [billID, typeOfBill, profitAndLoss, currentAmount, time]
     * @return boolean
     **/

    @Override
    public boolean addFinancialRevenueAndExpenditureInfo(String billID, String typeOfBill, String profitAndLoss, String currentAmount) {
        Connection conn = null;
        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            FinancialRevenueAndExpenditureInfoDAO dao = DAOSingleton.getFinancialRevenueAndExpenditureInfoDAO();

            int bid= Integer.parseInt(billID);
            BigDecimal pal = new BigDecimal(profitAndLoss);
            BigDecimal ca = new BigDecimal(profitAndLoss);
            //获取系统时间
            Timestamp nowtime = new Timestamp(System.currentTimeMillis());
            FinancialRevenueAndExpenditureInfo fre = new FinancialRevenueAndExpenditureInfo(bid, typeOfBill, pal, ca, nowtime);

            dao.insert(conn,fre);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        if(num>0){
            return true;
        }
        return false;
    }

    /**
     * @MethodName addMarketingInfo
     * @Author 周万宁
     * @Description 添加销售信息,部分参数需要转型,时间需要获取获取当前系统时间,
     * @Date 21:34 2022/12/3
     * @Param [drugID, drugName, unitPrice, number, customerID]
     * @return boolean
     **/


    @Override
    public boolean addMarketingInfo(String drugID, String drugName,String unitPrice, String number,  String customerID) {
        Connection conn = null;
        int num = 0;
        int newlyIncreasedInfoNum = 0;
        List<DrugInfo> list = null;
        BigDecimal newlyCurrentAmount = null;
        try {
            conn = JDBCUtils.getConnection();
            MarketingInfoDAO marketingInfoDAO = DAOSingleton.getMarketingInfoDAO();
            BigDecimal up = new BigDecimal(unitPrice);
            int numb = Integer.parseInt(number);
            BigDecimal amount = up.multiply(new BigDecimal(numb));
            int cid = Integer.parseInt(customerID);
            //获取系统时间
            Timestamp nowtime = new Timestamp(System.currentTimeMillis());
            MarketingInfo marketingInfo = new MarketingInfo(drugID, drugName, up, numb, amount, cid, nowtime);
            num = marketingInfoDAO.insert(conn, marketingInfo);
            System.out.println(num);
            //获取最新信息ID
            newlyIncreasedInfoNum = marketingInfoDAO.getTheLastListNumber(conn);
            System.out.println(newlyIncreasedInfoNum);
            //获取最新财政收支流水金额
            FinancialRevenueAndExpenditureInfoDAO financialRevenueAndExpenditureInfoDAO = DAOSingleton.getFinancialRevenueAndExpenditureInfoDAO();
            newlyCurrentAmount = financialRevenueAndExpenditureInfoDAO.getTheLastCurrentAmount(conn);
            //计算现流水金额
            BigDecimal currentAmount = newlyCurrentAmount.add(amount);
            //获取系统时间
            nowtime = new Timestamp(System.currentTimeMillis());
            FinancialRevenueAndExpenditureInfo fre = new FinancialRevenueAndExpenditureInfo(newlyIncreasedInfoNum, "marketing", amount, currentAmount, nowtime);
            //新增财政收支信息
            num = financialRevenueAndExpenditureInfoDAO.insert(conn, fre);
            System.out.println(num);
            //更新药品库存
            num = 0;
            DrugInfoDAO drugInfoDAO = DAOSingleton.getDrugInfoDAO();
            list = drugInfoDAO.getByID(conn, drugID);
            while (numb > 0) {
                for (int i = 0; i < list.size(); i++) {
                    DrugInfo drugInfo = list.get(i);
                    Date ED = drugInfo.getDateOfExpiry();
                    int inventory = drugInfo.getInventory();
                    LocalDate date = LocalDate.now();
                    if (ED.compareTo(java.util.Date.from(date.atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant())) > 0 && inventory > 0) {
                        DrugInfo drugInfo1 = list.get(i);
                        String nearBatchNumber = drugInfo1.getBatchNumber();
                        if (numb <= drugInfo1.getInventory()) {
                            num = drugInfoDAO.updateInventory(conn, drugID, nearBatchNumber, drugInfo1.getInventory() - numb);
                            numb = 0;
                            break;
                        }
                        if (numb > drugInfo1.getInventory()) {
                            num = drugInfoDAO.DeleteByIDAndBatch(conn, drugID, nearBatchNumber);
                            numb = numb - drugInfo1.getInventory();
                        }
                    }
                }
                if (num == 0) {
                    break;
                }
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        if(num>0){
            return true;
        }
        return false;
    }

    /**
     * @MethodName addOutboundInfo
     * @Author 周万宁
     * @Description 添加出库信息,需对部分参数转型,需要计算总金额,获取系统当前时间
     * @Date 21:41 2022/12/3
     * @Param [drugID, drugName, purchasingPrice, number, supplierID]
     * @return boolean
     **/

    @Override
    public boolean addOutboundInfo(String drugID, String drugName, String purchasingPrice, String number,  String supplierID) {
        Connection conn = null;
        int num = 0;
        List<DrugInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            OutboundInfoDAO dao = DAOSingleton.getOutboundInfoDAO();

            BigDecimal pp = new BigDecimal(purchasingPrice);
            int numb = Integer.parseInt(number);
            BigDecimal amount = pp.multiply(new BigDecimal(numb));
            //获取系统时间
            Timestamp nowtime = new Timestamp(System.currentTimeMillis());
            int sid = Integer.parseInt(supplierID);

            OutboundInfo outboundInfo = new OutboundInfo(drugID,drugName,pp,numb,amount,sid,nowtime);
            num = dao.insert(conn,outboundInfo);
            //更新药品库存
            num = 0;
            DrugInfoDAO drugInfoDAO = DAOSingleton.getDrugInfoDAO();
            list = drugInfoDAO.getByID(conn, drugID);
            while (numb > 0) {
                for (int i = 0; i < list.size(); i++) {
                    DrugInfo drugInfo = list.get(i);
                    Date ED = drugInfo.getDateOfExpiry();
                    int inventory = drugInfo.getInventory();
                    LocalDate date = LocalDate.now();
                    if (ED.compareTo(java.util.Date.from(date.atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant())) > 0 && inventory > 0) {
                        DrugInfo drugInfo1 = list.get(i);
                        String nearBatchNumber = drugInfo1.getBatchNumber();
                        if (numb <= drugInfo1.getInventory()) {
                            num = drugInfoDAO.updateInventory(conn, drugID, nearBatchNumber, drugInfo1.getInventory() - numb);
                            numb = 0;
                            break;
                        }
                        if (numb > drugInfo1.getInventory()) {
                            num = drugInfoDAO.DeleteByIDAndBatch(conn, drugID, nearBatchNumber);
                            numb = numb - drugInfo1.getInventory();
                        }
                    }
                }
                if (num == 0) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }



        if(num>0){
            return true;
        }
        return false;
    }

    /**
     * @MethodName addReturnInfo
     * @Author 周万宁
     * @Description 添加退货信息
     * @Date 21:47 2022/12/3
     * @Param [drugID, drugName, purchasingPrice, number, customerId]
     * @return boolean
     **/

    @Override
    public boolean addReturnInfo(String drugID, String drugName, String purchasingPrice, String number,  String customerId) {
        Connection conn = null;
        int num = 0;
        int newlyIncreasedInfoNum = 0;
        BigDecimal newlyCurrentAmount = null;
        List<DrugInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            ReturnInfoDAO returnInfoDAO = DAOSingleton.getReturnInfoDAO();
            BigDecimal pp = new BigDecimal(purchasingPrice);
            int numb = Integer.parseInt(number);
            int cid = Integer.parseInt(customerId);
            BigDecimal amount = pp.multiply(new BigDecimal(numb));
            //获取系统时间
            Timestamp nowtime = new Timestamp(System.currentTimeMillis());
            ReturnInfo returnInfo = new ReturnInfo(drugID, drugName, pp, numb, amount, cid, nowtime);
            num = returnInfoDAO.insert(conn,returnInfo);
            System.out.println(num);
            //获取最新消息ID
            newlyIncreasedInfoNum = returnInfoDAO.getTheLastListNumber(conn);
            System.out.println(newlyIncreasedInfoNum);
            //获取最新财政收支流水金额
            FinancialRevenueAndExpenditureInfoDAO financialRevenueAndExpenditureInfoDAO = DAOSingleton.getFinancialRevenueAndExpenditureInfoDAO();
            newlyCurrentAmount = financialRevenueAndExpenditureInfoDAO.getTheLastCurrentAmount(conn);
            System.out.println(newlyCurrentAmount);
            //计算现流水金额
            BigDecimal currentAmount = newlyCurrentAmount.subtract(amount);
            //获取系统时间
            nowtime = new Timestamp(System.currentTimeMillis());
            FinancialRevenueAndExpenditureInfo fre = new FinancialRevenueAndExpenditureInfo(newlyIncreasedInfoNum, "return", amount, currentAmount, nowtime);
            //新增财政收支信息
            num = financialRevenueAndExpenditureInfoDAO.insert(conn,fre);
            //更新药品库存
            num = 0;
            DrugInfoDAO drugInfoDAO = DAOSingleton.getDrugInfoDAO();
            list = drugInfoDAO.getByID(conn, drugID);
            for (int i = 0; i < list.size(); i++) {
                DrugInfo drugInfo = list.get(i);
                Date ED = drugInfo.getDateOfExpiry();
                int inventory = drugInfo.getInventory();
                LocalDate date = LocalDate.now();
                if (ED.compareTo(java.util.Date.from(date.atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant())) > 0 && inventory >= 0) {
                    DrugInfo drugInfo1 = list.get(i);
                    String nearBatchNumber = drugInfo1.getBatchNumber();
                    num = drugInfoDAO.updateInventory(conn, drugID, nearBatchNumber, drugInfo1.getInventory() + numb);
                    break;
                }
            }
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        if(num>0){
            return true;
        }
        return false;
    }

    /**
     * @MethodName addStorageEntryInfo
     * @Author 周万宁
     * @Description 添加入库信息
     * @Date 21:50 2022/12/3
     * @Param [drugID, drugName, purchasingPrice, number, supplierID]
     * @return boolean
     **/

    @Override
    public boolean addStorageEntryInfo(String drugID, String drugName, String purchasingPrice, String number, String supplierID) {
        Connection conn = null;
        int num = 0;
        int newlyIncreasedInfoNum = 0;
        BigDecimal newlyCurrentAmount = null;
        List<DrugInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            StorageEntryInfoDAO storageEntryInfoDAO = DAOSingleton.getStorageEntryInfoDAO();
            BigDecimal pp = new BigDecimal(purchasingPrice);
            int numb = Integer.parseInt(number);
            BigDecimal amount = pp.multiply(new BigDecimal(numb));
            //获取系统时间
            Timestamp nowtime = new Timestamp(System.currentTimeMillis());
            int sid = Integer.parseInt(supplierID);
            StorageEntryInfo storageEntryInfo = new StorageEntryInfo(drugID, drugName, pp, numb, amount, sid, nowtime);
            num = storageEntryInfoDAO.insert(conn,storageEntryInfo);
            //获取最新消息ID
            newlyIncreasedInfoNum = storageEntryInfoDAO.getTheLastListNumber(conn);
            //获取最新财政收支流水金额
            FinancialRevenueAndExpenditureInfoDAO financialRevenueAndExpenditureInfoDAO = DAOSingleton.getFinancialRevenueAndExpenditureInfoDAO();
            newlyCurrentAmount = financialRevenueAndExpenditureInfoDAO.getTheLastCurrentAmount(conn);
            //计算现流水金额
            BigDecimal currentAmount = newlyCurrentAmount.subtract(amount);
            //获取系统时间
            nowtime = new Timestamp(System.currentTimeMillis());
            FinancialRevenueAndExpenditureInfo fre = new FinancialRevenueAndExpenditureInfo(newlyIncreasedInfoNum, "storageEntry", amount, currentAmount, nowtime);
            //新增财政收支信息
            num = financialRevenueAndExpenditureInfoDAO.insert(conn,fre);
            //更新药品库存
            num = 0;
            DrugInfoDAO drugInfoDAO = DAOSingleton.getDrugInfoDAO();
            list = drugInfoDAO.getByID(conn, drugID);
            for (int i = 0; i < list.size(); i++) {
                DrugInfo drugInfo = list.get(i);
                Date ED = drugInfo.getDateOfExpiry();
                int inventory = drugInfo.getInventory();
                LocalDate date = LocalDate.now();
                if (ED.compareTo(java.util.Date.from(date.atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant())) > 0 && inventory >= 0) {
                    DrugInfo drugInfo1 = list.get(i);
                    String nearBatchNumber = drugInfo1.getBatchNumber();
                    num = drugInfoDAO.updateInventory(conn, drugID, nearBatchNumber, drugInfo1.getInventory() + numb);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }


        if(num>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addSupplierInfo(String name, String agent, String phone, String address) {
        Connection conn = null;
        int num = 0;

        try {
            conn = JDBCUtils.getConnection();
            SupplierInfoDAO dao = DAOSingleton.getSupplierInfoDAO();

            SupplierInfo supplierInfo = new SupplierInfo(name, agent, phone, address);
            num = dao.insert(conn,supplierInfo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

        if(num>0){
            return true;
        }
        return false;
    }
}
