package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    public List<EmployeePayrollData> employeePayrolllist;
    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollData)
    {
        this.employeePayrolllist=employeePayrollData;
    }

    public void readEmployeePayroll(Scanner scanner)
    {
        System.out.println("Enter Id: ");
        int id=scanner.nextInt();
        System.out.println("Enter Name: ");
        String name=scanner.next();
        System.out.println("Enter Salary: ");
        long salary=scanner.nextLong();
        employeePayrolllist.add(new EmployeePayrollData(id,name,salary));
    }

    public void writeEmployeePayrollData()
    {
        System.out.println("Writing Employee Payroll Service in Console " + employeePayrolllist);
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Employee Payroll Service Project");
        ArrayList<EmployeePayrollData> employeepayrolllist = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeepayrolllist);
        Scanner scanner=new Scanner(System.in);
        employeePayrollService.readEmployeePayroll(scanner);
        employeePayrollService.writeEmployeePayrollData();

    }
}
