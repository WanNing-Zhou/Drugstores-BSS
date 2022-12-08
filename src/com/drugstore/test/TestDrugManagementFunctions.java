package com.drugstore.test;

import com.drugstore.bean.CustomerInfo;
import com.drugstore.bean.DrugInfo;
import com.drugstore.bean.EmployeesInfo;
import com.drugstore.bean.SupplierInfo;
import com.drugstore.dao.CustomerInfoDAO;
import com.drugstore.dao.DrugInfoDAO;
import com.drugstore.dao.EmployeesInfoDAO;
import com.drugstore.dao.SupplierInfoDAO;
import com.drugstore.factory.DAOSingleton;
import com.drugstore.utils.JDBCUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestDrugManagementFunctions {
    public static void main(String[] args) {
        System.out.println("Test drug management functions");
    }
    @Test
    public void testAddDrugInfo() {
        Connection conn = null;
        int num = 0;
        try {
            DrugInfoDAO drugInfoDAO = DAOSingleton.getDrugInfoDAO();
            conn = JDBCUtils.getConnection();
            String drugID = "SWYGY";
            String name = "维三维鱼肝油";
            String supplierID = "2";
            String batchNumber = "2203073";
            String placeOfOrigin = "福建省厦门市沧海区新美路36号";
            String categoryOfOwnership = "维生素类非处方药药品";
            String purchasingPrice = "78.54";
            String unitPrice = "100.98";
            String inventory = "0";
            String dateOfProduction = "2022-03-07";
            String dateOfExpiry = "2024-12-30";
            int sID = Integer.parseInt(supplierID);
            BigDecimal pp = new BigDecimal(purchasingPrice);
            BigDecimal up = new BigDecimal(unitPrice);
            int inv = Integer.parseInt(inventory);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dop = new Date(sdf.parse(dateOfProduction).getTime());
            Date doe = new Date(sdf.parse(dateOfExpiry).getTime());
            DrugInfo drug = new DrugInfo(drugID,name,sID,batchNumber,placeOfOrigin,categoryOfOwnership,pp,up,inv,dop,doe);
            num = drugInfoDAO.insert(conn,drug);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testUpdateDrugInfo() {
        Connection conn = null;
        int num = 0;
        try {
            conn = JDBCUtils.getConnection();
            DrugInfoDAO dao = DAOSingleton.getDrugInfoDAO();
            String drugID = "SWYGY";
            String unitPrice = "100.86";
            BigDecimal up = new BigDecimal(unitPrice);
            num = dao.update(conn,drugID, up);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testDeleteDrugInfo() {
        Connection conn = null;
        int  num = 0;
        try {
            conn = JDBCUtils.getConnection();
            DrugInfoDAO dao = DAOSingleton.getDrugInfoDAO();
            String id = "SWYGY";
            String batchNumber = "2203072";
            num = dao.DeleteByIDAndBatch(conn,id,batchNumber);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetAllDrugInfo() {
        Connection conn = null;
        List<DrugInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            DrugInfoDAO dao = DAOSingleton.getDrugInfoDAO();
            list = dao.getAllDrug(conn);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetAllDrugInfoWithFuzzySearch() {
        Connection conn = null;
        List<DrugInfo> list = null;
        try {
            conn = JDBCUtils.getConnection();
            DrugInfoDAO dao = DAOSingleton.getDrugInfoDAO();
            String incompleteName = "三";
            String incompleteCategoryOfOwnership = " ";
            list = dao.getAllDrugWithFuzzySearch(conn, incompleteName, incompleteCategoryOfOwnership);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testGetDrugInventoryByID() {
        Connection conn = null;
        List<DrugInfo> list = null;
        int num = 0;
        try {
            conn = JDBCUtils.getConnection();
            DrugInfoDAO drugInfoDAO = DAOSingleton.getDrugInfoDAO();
            String drugID = "WSSADRJN";
            int numb = 35;
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
}
