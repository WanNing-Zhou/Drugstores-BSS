package com.drugstore.bean;

/**
 * @author 周万宁
 * @className EmployeesInfo
 * @description: 员工信息表
 * @create 2022-12-18:36
 */
public class EmployeesInfo {
    private int employeesID;//员工ID
    private String name;//员工姓名
    private String password;//员工密码
    private String position;//员工职位
    private String phone;//员工电话

    public EmployeesInfo() {
    }

    public EmployeesInfo(int employeesID, String name, String password, String position, String phone) {
        this.employeesID = employeesID;
        this.name = name;
        this.password = password;
        this.position = position;
        this.phone = phone;
    }

    public int getEmployeesID() {
        return employeesID;
    }

    public void setEmployeesID(int employeesID) {
        this.employeesID = employeesID;
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
                "employeesID=" + employeesID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
