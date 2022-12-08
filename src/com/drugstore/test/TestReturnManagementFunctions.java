package com.drugstore.test;

import com.drugstore.bean.*;
import com.drugstore.dao.*;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.service.GetTheLastListNumber;
import com.drugstore.utils.JDBCUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

public class TestReturnManagementFunctions {
    public static void main(String[] args) {
        System.out.println("Test return management functions");
    }
    @Test
    public void testAddReturnInfo() {
        Connection conn = null;
        int num = 0;
        int newlyIncreasedInfoNum = 0;
        BigDecimal newlyCurrentAmount = null;
        List<DrugInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            ReturnInfoDAO returnInfoDAO = DAOSingleton.getReturnInfoDAO();
            String drugID = "SWYGY";
            String drugName = "三维鱼肝油";
            String purchasingPrice = "100.86";
            String number = "10";
            String customerId = "3";
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
            System.out.println(num);
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
                    System.out.println(ED);
                    DrugInfo drugInfo1 = list.get(i);
                    System.out.println(i);
                    String nearBatchNumber = drugInfo1.getBatchNumber();
                    System.out.println(nearBatchNumber);
                    num = drugInfoDAO.updateInventory(conn, drugID, nearBatchNumber, drugInfo1.getInventory() + numb);
                    numb = 0;
                    break;
                }
            }
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetAllReturnInfo() {
        Connection conn = null;
        List<ReturnInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            ReturnInfoDAO dao = DAOSingleton.getReturnInfoDAO();
            list = dao.getAllRet(conn);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetAllReturnInfoWithFuzzySearch() {
        Connection conn = null;
        List<ReturnInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            ReturnInfoDAO dao = DAOSingleton.getReturnInfoDAO();
            String incompleteName = "三";
            String customerID = "2";
            int cid = Integer.parseInt(customerID);
            list = dao.getAllRetWithFuzzySearch(conn, incompleteName, cid);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetReturnInfo() {
        Connection conn = null;
        ReturnInfo returnInfo = null;
        try {
            conn = JDBCUtils.getConnection();
            ReturnInfoDAO dao = DAOSingleton.getReturnInfoDAO();
            String id = "2";
            returnInfo = dao.getByID(conn,Integer.parseInt(id));
            System.out.println(returnInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}
