package com.drugstore.bean;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author 周万宁
 * className StorageEntryInfo
 * create 2022/12/1-19:23
 * description 入库信息表
 */
public class StorageEntryInfo {

    private int storageEntryID; //入库ID
    private String drugID;  //药品ID
    private String drugName;    //药品名称
    private BigDecimal purchasingPrice;//进价
    private int number;//数量
    private BigDecimal amount;//总金额
    private int supplierID;//供应商ID
    private Timestamp time;//时间

    public StorageEntryInfo() {
    }

    public StorageEntryInfo(String drugID, String drugName, BigDecimal purchasingPrice, int number, BigDecimal amount, int supplierID, Timestamp time) {
        this.drugID = drugID;
        this.drugName = drugName;
        this.purchasingPrice = purchasingPrice;
        this.number = number;
        this.amount = amount;
        this.supplierID = supplierID;
        this.time = time;
    }

    public StorageEntryInfo(int storageEntryID, String drugID, String drugName, BigDecimal purchasingPrice, int number, BigDecimal amount, int supplierID, Timestamp time) {
        this.storageEntryID = storageEntryID;
        this.drugID = drugID;
        this.drugName = drugName;
        this.purchasingPrice = purchasingPrice;
        this.number = number;
        this.amount = amount;
        this.supplierID = supplierID;
        this.time = time;
    }

    public int getStorageEntryID() {
        return storageEntryID;
    }

    public void setStorageEntryID(int storageEntryID) {
        this.storageEntryID = storageEntryID;
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

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public Timestamp getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "StorageEntryInfo{" +
                "storageEntryID=" + storageEntryID +
                ", drugID='" + drugID + '\'' +
                ", drugName='" + drugName + '\'' +
                ", purchasingPrice=" + purchasingPrice +
                ", number=" + number +
                ", amount=" + amount +
                ", supplierID='" + supplierID + '\'' +
                ", time=" + time +
                '}';
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
