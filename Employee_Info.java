package com.example.test2b_csd214;

public class Employee_Info {
    private int EmpID;
    private String EmpName;

    private String EmpSalary;

    private String EmpDepartment;

    public Employee_Info(int EmpID, String EmpName, String EmpSalary, String EmpDepartment) {
        this.EmpID = EmpID;
        this.EmpName = EmpName;
        this.EmpSalary = EmpSalary;
        this.EmpDepartment = EmpDepartment;
    }

    public int getEmpID() {
        return EmpID;
    }

    public void setEmpID(int empID) {
        EmpID = empID;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public String getEmpSalary() {
        return EmpSalary;
    }

    public void setEmpSalary(String empSalary) {
        EmpSalary = empSalary;
    }

    public String getEmpDepartment() {
        return EmpDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        EmpDepartment = empDepartment;
    }

}