package com.drugstore.bean;


import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author 周万宁
 * class FinancialRevenueAndExpenditureInfo
 * createdate 2022/12/1-19:28
 * description 财政收支信息表
 */
public class FinancialRevenueAndExpenditureInfo {
    private int financialRevenueAndExpenditureID;//财政收支表单ID
    private int billID ;//账单ID
    private String typeOfBill;//账单类别
    private BigDecimal profitAndLoss; //盈亏
    private BigDecimal currentAmount;//流动金额
    private Timestamp time;//时间

    public FinancialRevenueAndExpenditureInfo() {
    }

    public FinancialRevenueAndExpenditureInfo(int financialRevenueAndExpenditureID, int billID, String typeOfBill, BigDecimal profitAndLoss, BigDecimal currentAmount, Timestamp time) {
        this.financialRevenueAndExpenditureID = financialRevenueAndExpenditureID;
        this.billID = billID;
        this.typeOfBill = typeOfBill;
        this.profitAndLoss = profitAndLoss;
        this.currentAmount = currentAmount;
        this.time = time;
    }

    public int getFinancialRevenueAndExpenditureID() {
        return financialRevenueAndExpenditureID;
    }

    public void setFinancialRevenueAndExpenditureID(int financialRevenueAndExpenditureID) {
        this.financialRevenueAndExpenditureID = financialRevenueAndExpenditureID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public String getTypeOfBill() {
        return typeOfBill;
    }

    public void setTypeOfBill(String typeOfBill) {
        this.typeOfBill = typeOfBill;
    }

    public BigDecimal getProfitAndLoss() {
        return profitAndLoss;
    }

    public void setProfitAndLoss(BigDecimal profitAndLoss) {
        this.profitAndLoss = profitAndLoss;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FinancialRevenueAndExpenditureInfo{" +
                "financialRevenueAndExpenditureID=" + financialRevenueAndExpenditureID +
                ", billID=" + billID +
                ", typeOfBill='" + typeOfBill + '\'' +
                ", profitAndLoss=" + profitAndLoss +
                ", currentAmount=" + currentAmount +
                ", time=" + time +
                '}';
    }
}
