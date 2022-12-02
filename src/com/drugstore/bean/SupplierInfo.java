package com.drugstore.bean;

import java.math.BigInteger;

/**
 * @author 周万宁
 * @className SupplierInfo
 * @description: 供应商信息表
 * @create 2022-12-18:39
 */
public class SupplierInfo {
    private int supplierID; //供应商ID
    private String name;//供应商名字
    private String agent;//代理人
    private String  phone;//供应商电话
    private String address;//供应商地址

    public SupplierInfo() {
    }

    public SupplierInfo(int supplierID, String name, String agent, String phone, String address) {
        this.supplierID = supplierID;
        this.name = name;
        this.agent = agent;
        this.phone = phone;
        this.address = address;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "SupplierInfo{" +
                "supplierID=" + supplierID +
                ", name='" + name + '\'' +
                ", agent='" + agent + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
