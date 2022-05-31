package com.bridgelabz;

public class EmployeePayrollData {

    public String startdate;
    public int id;
    public String name;
    public long salary;

    public EmployeePayrollData(int id, String name, long salary,String startdate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startdate=startdate;
    }

    @Override
    public String toString() {
        return "Employee PayRoll Data [id="+id + ", name = " +name+ ", Salary = " + salary + ",Start_date "+startdate+" ]";
    }
}

