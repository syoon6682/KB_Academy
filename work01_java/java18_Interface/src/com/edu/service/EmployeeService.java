package com.edu.service;

import com.edu.parent.Employee;

// 사용자와 밴더사 사이의 강력한 Contract~~!!

public interface EmployeeService {
	void printAllEmployee(Employee[] emps);
	
	Employee findEmployee(Employee[] emps, String name);
	
	Employee[] findEmployeeByDept(Employee[] emps, String dept);
	
	double getAnnualSalary(Employee e);
	
	double getTotalCost(Employee[] ea);
	
}
