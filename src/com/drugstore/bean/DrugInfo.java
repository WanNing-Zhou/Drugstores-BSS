package com.drugstore.bean;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author 周万宁
 * @className DrugInfo
 * @create 2022-12-1-18:57
 * @description 药品信息表
 */
public class DrugInfo {
    private String drugID;//药品ID
    private String name;//药品名称
    private int supplierID;//供应商ID
    private String batchNumber;//生产批号
    private String placeOfOrigin;//产地
    private String categoryOfOwnership;//所属类别
    private BigDecimal purchasingPrice;//进价
    private BigDecimal unitPrice;//单价
    private int inventory;//库存
    private Date dateOfProduction;//生产日期
    private Date dateOfExpiry;//有效期至


    public DrugInfo() {
    }

    public DrugInfo(String drugID, String name, int supplierID, String batchNumber, String placeOfOrigin, String categoryOfOwnership, BigDecimal purchasingPrice, BigDecimal unitPrice, int inventory, Date dateOfProduction, Date dateOfExpiry) {
        this.drugID = drugID;
        this.name = name;
        this.supplierID = supplierID;
        this.batchNumber = batchNumber;
        this.placeOfOrigin = placeOfOrigin;
        this.categoryOfOwnership = categoryOfOwnership;
        this.purchasingPrice = purchasingPrice;
        this.unitPrice = unitPrice;
        this.inventory = inventory;
        this.dateOfProduction = dateOfProduction;
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigion) {
        this.placeOfOrigin = placeOfOrigion;
    }

    public String getCategoryOfOwnership() {
        return categoryOfOwnership;
    }

    public void setCategoryOfOwnership(String categoryOfOwnership) {
        this.categoryOfOwnership = categoryOfOwnership;
    }

    public BigDecimal getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(BigDecimal purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Date getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(Date dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public String toString() {
        return "DrugInfo{" +
                "drugID='" + drugID + '\'' +
                ", name='" + name + '\'' +
                ", supplierID='" + supplierID + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                ", placeOfOrigion='" + placeOfOrigin + '\'' +
                ", categoryOfOwnership='" + categoryOfOwnership + '\'' +
                ", purchasingPrice=" + purchasingPrice +
                ", unitPrice=" + unitPrice +
                ", inventory=" + inventory +
                ", dateOfProduction=" + dateOfProduction +
                ", dateOfExpiry=" + dateOfExpiry +
                '}';
    }


}
