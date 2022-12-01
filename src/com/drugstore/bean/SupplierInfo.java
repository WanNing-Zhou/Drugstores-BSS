package com.drugstore.bean;

import java.math.BigInteger;

/**
 * @author 周万宁
 * @className SupplierInfo
 * @description: 供应商信息表
 * @create 2022-12-18:39
 */
public class SupplierInfo {
    private String ID;
    private String name;
    private String agent;
    private String  phone;
    private String address;

    public SupplierInfo() {
    }

    public SupplierInfo(String ID, String name, String agent, String phone, String address) {
        this.ID = ID;
        this.name = name;
        this.agent = agent;
        this.phone = phone;
        this.address = address;
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

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SupplierInfo{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", agent='" + agent + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
