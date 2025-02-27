package com.example.domain;

//import java.text.NumberFormat;
//import java.time.temporal.Temporal;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Manager extends Employee{
	private String deptName;
	private Employee[] staff;
	private int employeeCount;
	
	
	
	public Manager(int empId, String name, String ssn, double salary, String deptName) {
		super(empId, name, ssn, salary);
		this.deptName = deptName;
		this.employeeCount = 0;
		
		this.staff = new Employee[20];
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public int findEmployee(Employee emp) {
		for (int i = 0; i < employeeCount; i++) {
			if (staff[i] == emp) {
				return i;
			}
		}
		return -1;
	}
	public boolean addEmployee(Employee emp) {
		if(findEmployee(emp) != -1) {
			return false;
		}
		if(employeeCount < staff.length) {
			staff[employeeCount] = emp;
			employeeCount += 1;
			return true;
		}
		return false;
	}
	public boolean removeEmployee(Employee emp) {
		boolean status = false;
		Employee[] temp = new Employee[20];
		int cnt = 0;
		
		for(int i = 0; i < employeeCount; i++) {
			if(staff[i] != emp) {
				temp[cnt] = staff[i];
				cnt++;
			}else {
				status = true;
			}
		}
		if(status == true) {
			staff = temp;
			employeeCount = cnt;
		}
		return status;
	}
	
	public void printStaffDetails() {
		System.out.println("Manager: " + getName());
		
		for (int i = 0; i < employeeCount; i++) {
			System.out.println("Employee #" + (i + 1) + ": " + (staff[i]));
		}
	}
}
