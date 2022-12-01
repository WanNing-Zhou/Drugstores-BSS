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
    private String ID;
    private String name;
    private String supplierID;
    private String placeOfOrigion;
    private String categoryOfOwnership;
    private BigDecimal purchasingPrice;
    private BigDecimal unitPrice;
    private int inventory;
    private Date dateOfProduction;
    private Date dateOfExpiry;


    public DrugInfo() {
    }

    public DrugInfo(String ID, String name, String supplierID, String placeOfOrigion, String categoryOfOwnership, BigDecimal purchasingPrice, BigDecimal unitPrice, int inventory, Date dateOfProduction, Date dateOfExpiry) {
        this.ID = ID;
        this.name = name;
        this.supplierID = supplierID;
        this.placeOfOrigion = placeOfOrigion;
        this.categoryOfOwnership = categoryOfOwnership;
        this.purchasingPrice = purchasingPrice;
        this.unitPrice = unitPrice;
        this.inventory = inventory;
        this.dateOfProduction = dateOfProduction;
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getPlaceOfOrigion() {
        return placeOfOrigion;
    }

    public void setPlaceOfOrigion(String placeOfOrigion) {
        this.placeOfOrigion = placeOfOrigion;
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
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", supplierID='" + supplierID + '\'' +
                ", placeOfOrigion='" + placeOfOrigion + '\'' +
                ", categoryOfOwnership='" + categoryOfOwnership + '\'' +
                ", purchasingPrice=" + purchasingPrice +
                ", unitPrice=" + unitPrice +
                ", inventory=" + inventory +
                ", dateOfProduction=" + dateOfProduction +
                ", dateOfExpiry=" + dateOfExpiry +
                '}';
    }
}
