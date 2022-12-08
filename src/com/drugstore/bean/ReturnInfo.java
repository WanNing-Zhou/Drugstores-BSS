package com.drugstore.bean;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author 周万宁
 * @className ReturnInfo
 * @create 2022/12/1-19:19
 * @description 退货信息表
 */
public class ReturnInfo {
    private int returnID; //退货信息ID
    private String drugID; //药品ID
    private String drugName;//药品名称
    private BigDecimal unitPrice;//单价
    private int number;//数量
    private BigDecimal amount;//总金额
    private int customerID;//顾客ID
    private Timestamp time;//退货时间

    public ReturnInfo() {

    }

    public ReturnInfo(String drugID, String drugName, BigDecimal unitPrice, int number, BigDecimal amount, int customerId, Timestamp time) {
        this.drugID = drugID;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.number = number;
        this.amount = amount;
        this.customerID = customerId;
        this.time = time;
    }

    public ReturnInfo(int returnID, String drugID, String drugName, BigDecimal unitPrice, int number, BigDecimal amount, int customerId, Timestamp time) {
        this.returnID = returnID;
        this.drugID = drugID;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.number = number;
        this.amount = amount;
        this.customerID = customerId;
        this.time = time;
    }

    public int getReturnID() {
        return returnID;
    }

    public void setReturnID(int returnID) {
        this.returnID = returnID;
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

    public int getCustomerId() {
        return customerID;
    }

    public void setCustomerId(int customerId) {
        this.customerID = customerId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ReturnInfo{" +
                "returnID=" + returnID +
                ", drugID='" + drugID + '\'' +
                ", drugName='" + drugName + '\'' +
                ", unitPrice=" + unitPrice +
                ", number=" + number +
                ", amount=" + amount +
                ", customerId='" + customerID + '\'' +
                ", time=" + time +
                '}';
    }
}
