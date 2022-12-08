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

public class TestOutboundManagementFunctions {
    public static void main(String[] args) {
        System.out.println("Test outbound management functions");
    }
    @Test
    public void testAddOutboundInfo() {
        Connection conn = null;
        int num = 0;
        int newlyIncreasedInfoNum = 0;
        BigDecimal newlyCurrentAmount = null;
        List<DrugInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            OutboundInfoDAO outboundInfoDAO = DAOSingleton.getOutboundInfoDAO();
            String drugID = "SWYGY";
            String drugName = "三维鱼肝油";
            String purchasingPrice = "100.86";
            String number = "100";
            String supplierID = "1";
            BigDecimal pp = new BigDecimal(purchasingPrice);
            int numb = Integer.parseInt(number);
            BigDecimal amount = pp.multiply(new BigDecimal(numb));
            //获取系统时间
            Timestamp nowtime = new Timestamp(System.currentTimeMillis());
            int sid = Integer.parseInt(supplierID);
            OutboundInfo outboundInfo = new OutboundInfo(drugID,drugName,pp,numb,amount,sid,nowtime);
            num = outboundInfoDAO.insert(conn,outboundInfo);
            System.out.println(num);
            //获取最新消息ID
            newlyIncreasedInfoNum = outboundInfoDAO.getTheLastListNumber(conn);
            System.out.println(newlyIncreasedInfoNum);
            //获取最新财政收支流水金额
            FinancialRevenueAndExpenditureInfoDAO financialRevenueAndExpenditureInfoDAO = DAOSingleton.getFinancialRevenueAndExpenditureInfoDAO();
            newlyCurrentAmount = financialRevenueAndExpenditureInfoDAO.getTheLastCurrentAmount(conn);
            System.out.println(newlyCurrentAmount);
            //计算现流水金额
            BigDecimal currentAmount = newlyCurrentAmount.add(amount);
            //获取系统时间
            nowtime = new Timestamp(System.currentTimeMillis());
            FinancialRevenueAndExpenditureInfo fre = new FinancialRevenueAndExpenditureInfo(newlyIncreasedInfoNum, "outbound", amount, currentAmount, nowtime);
            //新增财政收支信息
            num = financialRevenueAndExpenditureInfoDAO.insert(conn,fre);
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
                        System.out.println(ED);
                        DrugInfo drugInfo1 = list.get(i);
                        String nearBatchNumber = drugInfo1.getBatchNumber();
                        if (numb <= drugInfo1.getInventory()) {
                            num = drugInfoDAO.updateInventory(conn, drugID, nearBatchNumber, drugInfo1.getInventory() - numb);
                            numb = 0;
                            break;
                        }
                        if (numb > drugInfo1.getInventory()) {
                            System.out.println(drugInfo1.getInventory());
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
    }
    @Test
    public void testGetALLOutboundInfo() {
        Connection conn = null;
        List<OutboundInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            OutboundInfoDAO dao = DAOSingleton.getOutboundInfoDAO();
            list = dao.getALLObi(conn);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetALLOutboundInfoWithFuzzySearch() {
        Connection conn = null;
        List<OutboundInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            OutboundInfoDAO dao = DAOSingleton.getOutboundInfoDAO();
            String incompleteName = "三";
            String supplierID = "1";
            int sid = Integer.parseInt(supplierID);
            list = dao.getALLObiWithFuzzySearch(conn, incompleteName, sid);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetOutboundInfo() {
        Connection conn = null;
        OutboundInfo outboundInfo = null;
        try {
            conn = JDBCUtils.getConnection();
            OutboundInfoDAO dao = DAOSingleton.getOutboundInfoDAO();
            String id = "1";
            outboundInfo = dao.getByID(conn,Integer.parseInt(id));
            System.out.println(outboundInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}
