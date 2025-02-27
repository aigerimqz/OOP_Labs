package com.example;



import com.example.business.EmployeeStockPlan;
import com.example.domain.Admin;
import com.example.domain.Director;
import com.example.domain.Employee;
import com.example.domain.Engineer;
import com.example.domain.Manager;



public class EmployeeTest {
	
	public static void main(String[] args) {
		
		Engineer eng1 = new Engineer(101, "Jane Smith", "012-34-5678", 120_345.27);
		Engineer eng2 = new Engineer(102, "Alex Brown", "012-34-5679", 120_320.34);
		Engineer eng3 = new Engineer(103,  "Tomiris Kair", "012-24-3243", 125_321.32);
		Manager man = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing");
		Admin adm = new Admin(304, "Bill Monroe", "108-23-6509", 75_002.34);
		
		Director dir = new Director(12, "Susan Wheeler", "099-45-2340", 120_567.36, "Global Marketing", 1_000_000.00);
		
		Manager mgr = new Manager(205, "Rose Bill", "048-11-6382", 99_434.23, "US Marketing");
		
		mgr.setName("Barbara Johnson-Smythe");
		mgr.raiseSalary(10_000.00);
		
//		man.addEmployee(eng1);
//		man.addEmployee(eng2);
//		man.addEmployee(eng3);
//		man.printStaffDetails();
		
		printEmployee(eng1);
		printEmployee(man);
		printEmployee(adm);
		printEmployee(dir);
		printEmployee(mgr);
		
		EmployeeStockPlan esp = new EmployeeStockPlan();
		printEmployee(eng1, esp);
		
	}
	public static void printEmployee(Employee emp) {
		System.out.println();
		System.out.println("Employee type:    " + emp.getClass().getSimpleName());
		System.out.println(emp);
	}
	
	
	
	public static void printEmployee(Employee emp, EmployeeStockPlan esp) {
		printEmployee(emp);
		System.out.println("Stock Options:    " + esp.grantStock(emp));
	}
	
	
	

}
