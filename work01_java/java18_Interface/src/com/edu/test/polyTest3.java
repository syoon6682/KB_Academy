package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.service.EmployeeService;
import com.edu.service.impl.EmployeeServiceImpl;
import com.edu.util.MyDate;

public class polyTest3 {
	public static void main(String[] args) {
		Employee[] emps = {
				new Manager("James", new MyDate(1990, 1, 1), 40000.0, "IT"),
				new Engineer("Tomas", new MyDate(1980, 2, 18), 32000.0, "Java", 30000.0),
				new Secretary("Adams", new MyDate(1995, 5, 2), 60000.0, "Marketing"),
				new Engineer("Tomas1", new MyDate(1980, 2, 18), 58000.0, "Python", 30000.0), 
				new Manager("Jane", new MyDate(1990, 1, 1), 40000.0, "IT"),
		};
		
		// service 객체 생성 == 메모리에 기능들을 로딩시킴
		EmployeeService service = EmployeeServiceImpl.getInstance();		

		// ========== 서비스 기능을 호출 ================
		
		System.out.println("\n=======");
		service.printAllEmployee(emps);
		
		System.out.println("\n=======");
		Employee temp = service.findEmployee(emps, "Jane");
		System.out.println(temp);
		
		
		System.out.println("\n=======");
		Employee[] test =  service.findEmployeeByDept(emps, "IT");
		
		for(Employee t: test) {
			System.out.println(t);
		}
		
		System.out.println("\n=======");
		
		System.out.println("\n=======");
		
	}

	
	
	
}


