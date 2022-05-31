package com.bridgelabz;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class EMPDB {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/Employee_Payroll?useSSL=false";
		String userName ="root";
		String password = "welcome123";
		Connection connection;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		listDrivers();
		try{
			System.out.println("Connecting to Database: " + jdbcURL);
			connection= DriverManager.getConnection(jdbcURL,userName,password);
			System.out.println("Connection is Successfully !!!!!" + connection);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	private static void listDrivers(){
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()){
			Driver driverClass =(Driver) driverList.nextElement();
			System.out.println(""+driverClass.getClass().getName());
		}
	}
}
