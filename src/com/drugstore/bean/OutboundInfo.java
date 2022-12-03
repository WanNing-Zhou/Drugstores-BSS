package com.drugstore.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author 周万宁
 * @className OutboundInfo
 * @create 2022/12/2-15:19
 * @description 出库信息表
 */
public class OutboundInfo {
    private int outboundID;//出库ID
    private String drugID;//药品ID
    private String drugName;//药品名称
    private BigDecimal purchasingPrice;//进价
    private int number;//数量
    private BigDecimal amount;//总金额
    private int supplierID;//供应商ID
    private Timestamp time;//时间


    public OutboundInfo() {
    }

    public OutboundInfo(String drugID, String drugName, BigDecimal purchasingPrice, int number, BigDecimal amount, int supplierID, Timestamp time) {
        this.drugID = drugID;
        this.drugName = drugName;
        this.purchasingPrice = purchasingPrice;
        this.number = number;
        this.amount = amount;
        this.supplierID = supplierID;
        this.time = time;
    }

    public int getOutboundID() {
        return outboundID;
    }

    public void setOutboundID(int outboundID) {
        this.outboundID = outboundID;
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

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OutboundInfo{" +
                "outboundID=" + outboundID +
                ", drugID='" + drugID + '\'' +
                ", drugName='" + drugName + '\'' +
                ", purchasingPrice=" + purchasingPrice +
                ", number=" + number +
                ", amount=" + amount +
                ", supplierID=" + supplierID +
                ", time=" + time +
                '}';
    }

    public OutboundInfo(int outboundID, String drugID, String drugName, BigDecimal purchasingPrice, int number, BigDecimal amount, int supplierID, Timestamp time) {
        this.outboundID = outboundID;
        this.drugID = drugID;
        this.drugName = drugName;
        this.purchasingPrice = purchasingPrice;
        this.number = number;
        this.amount = amount;
        this.supplierID = supplierID;
        this.time = time;
    }
}
