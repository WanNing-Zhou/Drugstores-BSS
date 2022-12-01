package com.drugstore.bean;

/**
 * @author 周万宁
 * @className CustomerInfo
 * @description: 对应客户信息表
 * @create 2022-12-18:33
 */
public class CustomerInfo {
    private String ID;
    private String name;
    private String phone;

    public CustomerInfo(String ID, String name, String phone) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
    }

    public CustomerInfo() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
