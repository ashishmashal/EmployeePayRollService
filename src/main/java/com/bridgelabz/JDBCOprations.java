package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
}
