package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static com.bridgelabz.EmployeePayrollService.IOService.FILE_IO;

public class EmployeeServiceTest {

    private EmployeePayrollService employeePayrollService;
    @Test
    public void givenEmployeeWhenWrittenToFileShouldMatchEmployeeEntries(){
        EmployeePayrollData[] employeePayrollData = {
                new EmployeePayrollData(121, "Ashish Mashal", 25000,"2020-20-20"),
                new EmployeePayrollData(122, "Vicky Jo", 32000,"2020-20-20"),
                new EmployeePayrollData(123, "Karan Kumar", 28490,"2020-20-20")};
        EmployeePayrollFileI0Service.writeData(List.of(employeePayrollData));
        EmployeePayrollService.printData(FILE_IO);
        EmployeePayrollService.countEntries(FILE_IO);
        System.out.println("No. of entries: "+employeePayrollData.length);
    }
    @Test
    public void givenFileOnReadingFromFileShouldMatchEmployeeCount(){
        employeePayrollService.readEmployeePayrollData(FILE_IO);

    }

}
