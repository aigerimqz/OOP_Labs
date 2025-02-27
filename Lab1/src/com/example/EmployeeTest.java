package com.example;

import com.example.domain.Employee;



public class EmployeeTest {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setEmpId(101);
		emp.setName("Jane Smith");
		emp.setSsn("012-34-5678");
		emp.setSalary(120_345.27);
		
		
		Employee emp1 = new Employee();
		emp1.setEmpId(102);
		emp1.setName("Arman Imanov");
		emp1.setSsn("122-46-7612");
		emp1.setSalary(95_234.54);
		
		System.out.println("Employee id:        " + emp.getEmpId() + "               " +emp1.getEmpId());
		System.out.println("Employee name:      " + emp.getName() + "      " + emp1.getName());
		System.out.println("Employee Soc Sec #: " + emp.getSsn() + "      " + emp1.getSsn());
		System.out.println("Employee salary:    " + emp.getSalary() + "       " + emp1.getSalary());
		
		
		
		
		

	}

}
