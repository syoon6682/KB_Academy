package com.edu.domain.test;

import com.edu.domain.Employee;
import com.edu.util.MyDate;

public class EmployeeTest {
	public static void main(String args[]) {
		Employee emp1 = new Employee("James", new MyDate(2000, 1, 1));
		Employee emp2 = new Employee("Tomas", 340000.0, new MyDate(1999, 4, 22));
		Employee emp3 = new Employee("Jane", 670000.0, new MyDate(1980, 11, 12));

		
		Employee[] emps = {emp1, emp2, emp3};
		for(Employee emp: emps)
			System.out.println(emp);
	}

}
