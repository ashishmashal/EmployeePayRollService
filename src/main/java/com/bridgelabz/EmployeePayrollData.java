package com.bridgelabz;

public class EmployeePayrollData {
    public int id;
    public String name;
    public long salary;

    public EmployeePayrollData(int id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee PayRoll Data [id="+id + ", name = " +name+ ", Salary = " + salary ;
    }
}

