package com.example.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Employee;

public class EmployeeDAOJDBCImpl implements EmployeeDAO{
	private Connection con = null;
	
	public EmployeeDAOJDBCImpl() {
		String url = "jdbc:derby://localhost:1527/EmployeeDB";
        String username = "public";
        String password = "tiger";
        
        try {
        	con = DriverManager.getConnection(url, username, password);
        } catch (SQLException se) {
        	System.out.println("Error obtaining connection with the database: " + se);
        	System.exit(-1);
        }
	}
	
	@Override
	public void close() throws Exception {
		try {
			con.close();
		} catch (SQLException se) {
			System.out.println("Exception closing Connection: " + se);
		} 
	}

	@Override
	public void add(Employee emp) throws DAOException {
		// TODO Auto-generated method stub
		try (Statement stmt = con.createStatement()){
			String checkQuery = "SELECT COUNT(*) FROM EMPLOYEE WHERE ID = " + emp.getId();
			ResultSet checkResult = stmt.executeQuery(checkQuery);
			checkResult.next();
			if(checkResult.getInt(1) > 0) {
				throw new DAOException("Employee with ID " + emp.getId() + " already exists.");
				
			}
			
			
			String query = "INSERT INTO EMPLOYEE VALUES(" + emp.getId() + 
					", '" + emp.getFirstName() + "', " + 
					"'" + emp.getLastName() + "', " + "'" + 
					new java.sql.Date(emp.getBirthDate().getTime()) + 
					"', " + emp.getSalary() + ")";
			if(stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error adding employee");
			}
			
		} catch (SQLException se) {
			// TODO: handle exception
			throw new DAOException("Error adding employee in DAO", se);
		}
		
		
	}

	@Override
	public void update(Employee emp) throws DAOException {
		try(Statement stmt = con.createStatement()){
			String query = "UPDATE EMPLOYEE " + 
		"SET FIRSTNAME='" + emp.getFirstName() + "'," + 
		"LASTNAME='" + emp.getLastName() + "'," + 
		"BIRTHDATE='" + new java.sql.Date(emp.getBirthDate().getTime()) + "'," + 
		"SALARY=" + emp.getSalary() + 
		"WHERE ID =" + emp.getId();
			
			if(stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error updating employee");
			}
		}catch (SQLException se) {
			throw new DAOException("Error updating employee in DAO", se);
		}
	}

	@Override
	public void delete(int id) throws DAOException {
		Employee emp = findById(id);
		if (emp == null) {
			throw new DAOException("Employee id: " + id + " does not exist to delete.");
		}
		try(Statement stmt = con.createStatement()){
			String query = "DELETE FROM EMPLOYEE WHERE ID=" + id;
			if(stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error deleting employee");
			}
		}catch (SQLException se) {
			throw new DAOException("Error deleting employee in DAO", se);
		}
	}

	@Override
	public Employee findById(int id) throws DAOException {
		try(Statement stmt = con.createStatement()){
			String query = "SELECT * FROM EMPLOYEE WHERE ID = " + id;
			ResultSet rs = stmt.executeQuery(query);
			
			if(!rs.next()) {
				return null;
			}
			return (new Employee(
					rs.getInt("ID"), 
					rs.getString("FIRSTNAME"), 
					rs.getString("LASTNAME"), 
					rs.getDate("BIRTHDATE"), 
					rs.getFloat("SALARY")
					));
		} catch (SQLException se) {
			throw new DAOException("Error finding employee in DAO", se);
		}
	}

	@Override
	public Employee[] getAllEmployees() throws DAOException {
		try (Statement stmt = con.createStatement()){
			String query = "SELECT * FROM EMPLOYEE";
			ResultSet rs = stmt.executeQuery(query);
			
			ArrayList<Employee> emps = new ArrayList<>();
			
			while(rs.next()) {
				emps.add(new Employee(rs.getInt("ID"), 
						rs.getString("FIRSTNAME"), 
						rs.getString("LASTNAME"), 
						rs.getDate("BIRTHDATE"), 
						rs.getFloat("SALARY")));
			}
			return emps.toArray(new Employee[0]);
		}catch (SQLException se) {
			throw new DAOException("Error getting all emloyees in DAO", se);
		}
	}
	

}
