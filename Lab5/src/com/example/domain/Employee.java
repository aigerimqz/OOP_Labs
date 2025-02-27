package com.example.domain;

import java.text.NumberFormat;

public class Employee {
	private int empId;
	private String name;
	private String ssn;
	private double salary;
	
	

	public Employee(int empId, String name, String ssn, double salary) {
		this.empId = empId;
		this.name = name;
		this.ssn = ssn;
		this.salary = salary;

		
	}

	public void setName(String name) {
		if((name != null) && !(name.trim().isEmpty())) {
			this.name = name;
		}else {
			System.out.println("Error! You  should type not empty and not null name.");
		}
		
	}
	
	public void raiseSalary(double increase) {
		if(increase > 0) {
			salary += increase;
		}else {
			System.out.println("Error! You should type only positive amount.");
		}
		
	}
	
	public String toString() {
		return "Employee ID:      " + getEmpId() + "\n" +
			   "Employee Name:    " + getName() + "\n" +
			   "Employee SSN:     " + getSsn() + "\n" +
			   "Employee Salary:  " + NumberFormat.getCurrencyInstance().format(getSalary());
			   
 	}
	
	public int getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}

	public String getSsn() {
		return ssn;
	}

	public double getSalary() {
		return salary;
	}
}
