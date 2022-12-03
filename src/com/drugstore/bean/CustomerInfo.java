package com.drugstore.bean;

/**
 * @author 周万宁
 * @className CustomerInfo
 * @description: 对应客户信息表
 * @create 2022-12-18:33
 */
public class CustomerInfo {

    private int customerID;//顾客ID
    private String name;//顾客姓名
    private String phone;//顾客电话

    public CustomerInfo() {

    }

    public CustomerInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public CustomerInfo(int customerID, String name, String phone) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
