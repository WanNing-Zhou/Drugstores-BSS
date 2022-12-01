package com.drugstore.bean;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author 周万宁
 * @className ReturnInfo
 * @create 2022/12/1-19:19
 * @description 退货信息表
 */
public class ReturnInfo {
    private String ID;
    private String drugID;
    private String drugName;
    private BigDecimal unitPrice;
    private int number;
    private BigDecimal amount;
    private String customerId;
    private Date time;

    public ReturnInfo() {
    }

    public ReturnInfo(String ID, String drugID, String drugName, BigDecimal unitPrice, int number, BigDecimal amount, String customerId, Date time) {
        this.ID = ID;
        this.drugID = drugID;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.number = number;
        this.amount = amount;
        this.customerId = customerId;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ReturnInfo{" +
                "ID='" + ID + '\'' +
                ", drugID='" + drugID + '\'' +
                ", drugName='" + drugName + '\'' +
                ", unitPrice=" + unitPrice +
                ", number=" + number +
                ", amount=" + amount +
                ", customerId='" + customerId + '\'' +
                ", time=" + time +
                '}';
    }
}
