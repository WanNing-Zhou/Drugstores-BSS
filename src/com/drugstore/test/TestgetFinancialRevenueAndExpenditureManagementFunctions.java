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

public class TestgetFinancialRevenueAndExpenditureManagementFunctions {
    public static void main(String[] args) {
        System.out.println("Test financialRevenueAndExpenditure management functions");
    }
    @Test
    public void testGetAllFinancialRevenueAndExpenditureInfo() {
        Connection conn = null;
        List<FinancialRevenueAndExpenditureInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            FinancialRevenueAndExpenditureInfoDAO dao = DAOSingleton.getFinancialRevenueAndExpenditureInfoDAO();
            list = dao.getAllFre(conn);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}
