package com.edu.service.impl;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.parent.Employee;
import com.edu.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	// 1
	static private EmployeeServiceImpl service = new EmployeeServiceImpl();

	// 2
	private EmployeeServiceImpl() {
		System.out.println("Client Request Ready...");
	}
	
	// 3.
	public static EmployeeServiceImpl getInstance() {
		return service;
	}
	
	
	@Override
	public void printAllEmployee(Employee[] emps) {
		for (Employee e : emps) {
			System.out.println(e);
		}
	}
	
	// 2. 모든 직원 중 특정한 직원을 검색하는 기능을 정의 -> 검색!
	// find~(), search~~()
	@Override
	public Employee findEmployee(Employee[] emps, String name) {
		Employee employee = null;
		for (Employee e : emps) {
			if (e.getName().equals(name)) {
				employee = e;
				break;
			}
		}
		
		return employee;
	}
	
	// 3. 모든 직원 중에서 동일한 부서에서 일하는 직원들을 검색
	// By~~를 통해 오버로딩을 강화하는 측면이 있다.
	@Override
	public Employee[] findEmployeeByDept(Employee[] emps, String dept) {
		Employee[] temp = new Employee[emps.length];
		
		int idx = 0;
		for (Employee e: emps) {
			if (e instanceof Manager) {
				if (((Manager) e).getDept().equals(dept)) {
					temp[idx++] = e;
				}
			}
		}
		
		return temp;
	}
	
	// 4. 특정한 직원의 연봉을 리턴하는 기능
	@Override
	public double getAnnualSalary(Employee e) {
		double annualSalary = 0;
		
		if (e instanceof Engineer) {
			annualSalary = e.getSalary() * 12 + ((Engineer) e).getBonus();
		} else {
			annualSalary = e.getSalary() * 12;
		}
		
		return annualSalary;
	}
	
	
	// 5. 모든 직원의 총 인건비를 리턴
	@Override
	public double getTotalCost(Employee[] ea) {
		double total = 0;
		
		for (Employee e : ea) {
			total += getAnnualSalary(e);
		}
		
		return total;
	}
	
}
