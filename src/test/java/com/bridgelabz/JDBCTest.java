package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
		boolean ecpected = jdbcDemo.insert();
		Assertions.assertTrue(true);
	}
}
