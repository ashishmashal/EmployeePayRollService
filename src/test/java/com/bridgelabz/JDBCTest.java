package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JDBCTest {
	@Test
	public void giveDataToCreateTable_IntoDatabase(){
		JDBCOprations jdbcDemo= new JDBCOprations();
		boolean expected = jdbcDemo.createTable();
		Assertions.assertTrue(true);
	}
	@Test
	public void GivenDataInsertDataInto_Database(){
		JDBCOprations jdbcDemo= new JDBCOprations();
		jdbcDemo.insert();
		Assertions.assertTrue(true);
	}

	@Test
	public void GivenDataSelectDataFromTable_Database(){
		JDBCOprations jdbcDemo= new JDBCOprations();
		List<EmployeePayrollData> employeeData=jdbcDemo.select();
		for(EmployeePayrollData employeeData1:employeeData){
			System.out.println(employeeData1);
		}
		Assertions.assertEquals(1,employeeData.size());
	}

	@Test
	public void GivenDatawhere_Database() {
		JDBCOprations jdbcDemo= new JDBCOprations();
		jdbcDemo.selectUsingWhere();
		Assertions.assertTrue(true);
	}

	@Test
	public void GivenDataAlter_Database(){
		JDBCOprations jdbcDemo= new JDBCOprations();
		 jdbcDemo.alter();
		Assertions.assertTrue(true);
	}

	@Test
	public void GivenDataUpdate_Database(){
		JDBCOprations jdbcDemo= new JDBCOprations();
		jdbcDemo.update();
		Assertions.assertTrue(true);
	}
}
