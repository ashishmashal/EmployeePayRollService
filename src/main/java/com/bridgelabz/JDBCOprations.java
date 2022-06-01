package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCOprations {
	String jdbcURL = "jdbc:mysql://localhost:3306/Employee_Payroll?useSSL=false";
	String userName = "root";
	String password = "welcome123";

	public boolean createTable() {
		try (Connection conn = DriverManager.getConnection(jdbcURL, userName, password);
		     Statement stmt = conn.createStatement()
		) {
			String sql = "CREATE TABLE emp " +
					"(id INTEGER NOT NULL PRIMARY KEY, " +
					" name VARCHAR(255), " +
					" salary VARCHAR(255),"+
					"startDate VARCHAR(255))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean insert() {
		try (Connection conn = DriverManager.getConnection(jdbcURL, userName, password);
		     Statement stmt = conn.createStatement()
		) {
			String sql = "INSERT INTO emp VALUES (1,'Vicky','500000','2022-05-25')";

			stmt.executeUpdate(sql);
			System.out.println("Inserted Data in given database...");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public List<EmployeePayrollData> select(){
		String sql="SELECT * FROM emp";
		List<EmployeePayrollData> employeeDataList=new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(jdbcURL, userName, password);
		     Statement stmt = conn.createStatement()
		){	ResultSet resultSet=stmt.executeQuery(sql);
			while (resultSet.next()){
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				double salary=resultSet.getDouble("salary");
				String startdate=resultSet.getString("startdate");
				employeeDataList.add(new EmployeePayrollData(id,name, (long) salary,startdate));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return employeeDataList;
	}

	public boolean selectUsingWhere(){
		String sql1="SELECT * FROM emp WHERE startDate BETWEEN CAST('2022-03-25' AS DATE) AND DATE(NOW())";
		try (Connection conn = DriverManager.getConnection(jdbcURL, userName, password);
		     Statement stmt = conn.createStatement()
		){
			ResultSet resultSet1=stmt.executeQuery(sql1);
			while (resultSet1.next()) {
				int numColumns = resultSet1.getMetaData().getColumnCount();
				for (int i = 1; i <= numColumns; i++) {
					System.out.println("COLUMN " + i + " = " + resultSet1.getObject(i));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return true;
	}
}
