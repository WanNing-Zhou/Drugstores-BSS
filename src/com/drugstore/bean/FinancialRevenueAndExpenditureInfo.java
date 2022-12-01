package com.drugstore.bean;


import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author 周万宁
 * class FinancialRevenueAndExpenditureInfo
 * createdate 2022/12/1-19:28
 * description 财政收支信息表
 */
public class FinancialRevenueAndExpenditureInfo {
    private String ID;
    private String billID ;
    private BigDecimal profitandLoss;
    private BigDecimal currentAmount;
    private Date time;

    public FinancialRevenueAndExpenditureInfo() {
    }

    public FinancialRevenueAndExpenditureInfo(String ID, String billID, BigDecimal profitandLoss, BigDecimal currentAmount, Date time) {
        this.ID = ID;
        this.billID = billID;
        this.profitandLoss = profitandLoss;
        this.currentAmount = currentAmount;
        this.time = time;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public BigDecimal getProfitandLoss() {
        return profitandLoss;
    }

    public void setProfitandLoss(BigDecimal profitandLoss) {
        this.profitandLoss = profitandLoss;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FinancialRevenueAndExpenditureInfo{" +
                "ID='" + ID + '\'' +
                ", billID='" + billID + '\'' +
                ", profitandLoss=" + profitandLoss +
                ", currentAmount=" + currentAmount +
                ", time=" + time +
                '}';
    }
}
