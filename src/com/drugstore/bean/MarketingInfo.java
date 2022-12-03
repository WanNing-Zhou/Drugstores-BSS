package com.drugstore.bean;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author 周万宁
 * @className MarketingInfo
 * @create 2022/12/1-19:14
 * @description 销售信息表
 */
public class MarketingInfo {
    private int marketingID; //销售ID
    private String drugID; //药品ID
    private String drugName;//药品名称
    private BigDecimal unitPrice;//单价
    private int number;//数量
    private BigDecimal amount;//总金额
    private int customerID;//顾客ID
    private Timestamp time;//时间

    public MarketingInfo() {
    }

    public MarketingInfo(String drugID, String drugName, BigDecimal unitPrice, int number, BigDecimal amount, int customerID, Timestamp time) {
        this.drugID = drugID;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.number = number;
        this.amount = amount;
        this.customerID = customerID;
        this.time = time;
    }

    public MarketingInfo(int marketingID, String drugID, String drugName, BigDecimal unitPrice, int number, BigDecimal amount, int customerID, Timestamp time) {
        this.marketingID = marketingID;
        this.drugID = drugID;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.number = number;
        this.amount = amount;
        this.customerID = customerID;
        this.time = time;
    }

    public int getMarketingID() {
        return marketingID;
    }

    public void setMarketingID(int marketingID) {
        this.marketingID = marketingID;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
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

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MarketingInfo{" +
                "marketingID=" + marketingID +
                ", drugID='" + drugID + '\'' +
                ", drugName='" + drugName + '\'' +
                ", unitPrice=" + unitPrice +
                ", number=" + number +
                ", amount=" + amount +
                ", customerID=" + customerID +
                ", time=" + time +
                '}';
    }
}
