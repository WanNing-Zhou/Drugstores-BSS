package com.drugstore.bean;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author 周万宁
 * className StorageEntryInfo
 * create 2022/12/1-19:23
 * description 入库信息表
 */
public class StorageEntryInfo {

    private String ID;
    private String drugID;
    private String drugName;
    private BigDecimal purchasingPrice;
    private int number;
    private BigDecimal amount;
    private String supplierID;
    private Date time;

    public StorageEntryInfo() {
    }

    public StorageEntryInfo(String ID, String drugID, String drugName, BigDecimal purchasingPrice, int number, BigDecimal amount, String supplierID, Date time) {
        this.ID = ID;
        this.drugID = drugID;
        this.drugName = drugName;
        this.purchasingPrice = purchasingPrice;
        this.number = number;
        this.amount = amount;
        this.supplierID = supplierID;
        this.time = time;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public BigDecimal getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(BigDecimal purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "StorageEntryInfo{" +
                "ID='" + ID + '\'' +
                ", drugID='" + drugID + '\'' +
                ", drugName='" + drugName + '\'' +
                ", purchasingPrice=" + purchasingPrice +
                ", number=" + number +
                ", amount=" + amount +
                ", supplierID='" + supplierID + '\'' +
                ", time=" + time +
                '}';
    }
}
