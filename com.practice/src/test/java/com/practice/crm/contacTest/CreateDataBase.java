package com.practice.crm.contacTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {

	public static void main(String[] args) throws Exception {
		
		String serverUrl = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root"; 
        
        String dbName = "company_db";
        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&serverTimezone=UTC";

        try {
            // 1. CREATE DATABASE
           
            try (Connection connServer = DriverManager.getConnection(serverUrl, user, password);
                 Statement stserver = connServer.createStatement()) {
                
                System.out.println("--- 1. CREATE DATABASE ---");
               
                stserver.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
                System.out.println("Database '" + dbName + "' created successfully");
            }

           
            try (Connection conn = DriverManager.getConnection(dbUrl, user, password);
                 Statement stmt = conn.createStatement()) {

                // 2. CREATE TABLE
                System.out.println("--- 2. CREATE TABLE ---");
                String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (" +
                                        "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                        "name VARCHAR(100) NOT NULL, " +
                                        "department VARCHAR(100) NOT NULL, " +
                                        "salary DOUBLE)";
                stmt.executeUpdate(createTableSQL);
                System.out.println("Table 'employees' created successfully.\n");

                // 3. INSERT RECORDS
                System.out.println("--- 3. INSERT RECORDS ---");
                String insertSQL = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    // Record 1
                    pstmt.setString(1, "Deepika");
                    pstmt.setString(2, "QA");
                    pstmt.setDouble(3, 75000.0);
                    pstmt.executeUpdate();

                    // Record 2
                    pstmt.setString(1, "Shweta");
                    pstmt.setString(2, "QA");
                    pstmt.setDouble(3, 62000.0);
                    pstmt.executeUpdate();

                    // Record 3
                    pstmt.setString(1, "Priya");
                    pstmt.setString(2, "QA");
                    pstmt.setDouble(3, 80000.0);
                    pstmt.executeUpdate();
                }
                System.out.println("Records inserted successfully");

                // 4. PRINT EVERYTHING (Initial State)
                System.out.println("--- 4. PRINT EVERYTHING (Initial State) ---");
                printRecords(stmt);

                // 5. UPDATE SOME RECORD
                System.out.println("--- 5. UPDATE SOME RECORD ---");
                String updateSQL = "UPDATE employees SET salary = ? WHERE name = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                	 pstmt.setDouble(1, 88000.0);
                	 pstmt.setString(2, "Shweta");
                   
                    pstmt.executeUpdate();
                }
                System.out.println("Record updated successfully.\n");

                // 6. PRINT THE RECORDS (After Update)
                System.out.println("--- 6. PRINT THE RECORDS (After Update) ---");
                printRecords(stmt);

                // 7. DELETE TABLE
                System.out.println("--- 7. DELETE TABLE ---");
                stmt.executeUpdate("DROP TABLE IF EXISTS employees");
                System.out.println("Table 'employees' deleted successfully");
            }

            // 8. DELETE DATABASE
            try (Connection connCleanup = DriverManager.getConnection(serverUrl, user, password);
                 Statement stmtCleanup = connCleanup.createStatement()) {
                
                System.out.println("--- 8. DELETE DATABASE ---");
                stmtCleanup.executeUpdate("DROP DATABASE IF EXISTS " + dbName);
                System.out.println("Database '" + dbName + "' deleted from localhost successfully.");
            }

        } catch (SQLException e) {
            System.out.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printRecords(Statement stmt) throws SQLException {
        String selectSQL = "SELECT id, name, department, salary FROM employees";
        try (ResultSet rs = stmt.executeQuery(selectSQL)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Dept: " + dept + ", Salary: " + salary);
            }
        }
        System.out.println();
    }

	}



