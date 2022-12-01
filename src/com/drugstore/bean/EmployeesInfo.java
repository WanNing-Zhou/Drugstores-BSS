package com.drugstore.bean;

/**
 * @author 周万宁
 * @className EmployeesInfo
 * @description: 员工信息表
 * @create 2022-12-18:36
 */
public class EmployeesInfo {
    private String ID;
    private String name;
    private String password;
    private String position;
    private String phone;

    public EmployeesInfo() {
    }

    public EmployeesInfo(String ID, String name, String password, String position, String phone) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.position = position;
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "EmployeesInfo{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
