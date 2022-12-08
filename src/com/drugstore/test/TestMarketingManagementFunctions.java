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
import java.util.concurrent.Callable;

public class TestMarketingManagementFunctions {
    public static void main(String[] args) {
        System.out.println("Test marketing management functions");
    }
    @Test
    public void testAddMarketingInfo() {
        Connection conn = null;
        int num = 0;
        int newlyIncreasedInfoNum = 0;
        List<DrugInfo> list = null;
        BigDecimal newlyCurrentAmount = null;
        try {
            conn = JDBCUtils.getConnection();
            MarketingInfoDAO marketingInfoDAO = DAOSingleton.getMarketingInfoDAO();
            String drugID = "WSSADRJN";
            String drugName = "维生素AD软胶囊";
            String unitPrice = "100.86";
            String number = "35";
            String customerID = "2";
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
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetAllMarketingInfo() {
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
        System.out.println(list);
    }
    @Test
    public void testGetAllMarketingInfoWithFuzzySearch() {
        Connection conn = null;
        List<MarketingInfo> list = null;

        try {
            conn = JDBCUtils.getConnection();
            MarketingInfoDAO dao = DAOSingleton.getMarketingInfoDAO();
            String incompleteName = " ";
            String customerID = "2";
            int cid= Integer.parseInt(customerID);
            list = dao.getAllMktWithFuzzySearch(conn, incompleteName, cid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        System.out.println(list);
    }
    @Test
    public void testGetMarketingInfo() {
        Connection conn = null;
        MarketingInfo mkt = null;
        try {
            conn = JDBCUtils.getConnection();
            MarketingInfoDAO dao = DAOSingleton.getMarketingInfoDAO();
            String id = "3";
            mkt = dao.getByID(conn,Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
        System.out.println(mkt);
    }
}
