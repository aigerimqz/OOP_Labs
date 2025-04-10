package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SimpleJDBCExample {

    public static void main(String[] args) {
        // Create the "url"
        // assume database server is running on the localhost
        String url = "jdbc:derby://localhost:1527/EmployeeDB";
        String username = "public";
        String password = "tiger";
        
        
        int addingID = 290;

        // Create a simple query
        String selectQuery = "select * from EMPLOYEE";
        String insertQuery = "insert into Employee values ("+addingID+", 'Bill', 'Murray', '1950-09-21', 150000)";
        // A try-with-resources example
        // Connection and Statement implement java.lan.AutoCloseable
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement stmt = con.createStatement();
            
            
            String checkQuery = "select count(*) from Employee where id = " + addingID;
            ResultSet checkResult = stmt.executeQuery(checkQuery);
            checkResult.next();
            if(checkResult.getInt(1) > 0) {
            	System.out.println("Employee with ID "+ addingID +" already exists.");
            }
            else {
            	int rowsAffected = stmt.executeUpdate(insertQuery);
            	if(rowsAffected == 1) {
            		System.out.println("New employee successfully added.");
            		
            	}else {
            		System.out.println("Error in adding!");
            	}
            }
            
            System.out.println("------------------------------------");
            
            ResultSet rs = stmt.executeQuery(selectQuery);
            
            while (rs.next()) {
                int empID = rs.getInt("ID");
                String first = rs.getString("FIRSTNAME");
                String last = rs.getString("LASTNAME");
                Date birth_date = rs.getDate("BIRTHDATE");
                float salary = rs.getFloat("SALARY");
                System.out.println("Employee ID:   " + empID + "\n"
                        + "Employee Name: " + first.trim() + " " + last.trim() + "\n"
                        + "Birth Date:    " + birth_date + "\n"
                        + "Salary:        " + salary + "\n");

            }
        } catch (SQLException e) {
            System.out.println("Exception creating connection: " + e);
            System.exit(0);
        }
        // No need to close the Connection and Statement objects, the compiler
        // will generate these for us and call the close() statement on this
        // objects in the order we obtained them in the try
    }
}