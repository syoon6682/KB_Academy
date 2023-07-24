package com.edu.test;

/*
 * 
 */

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class polyTest2 {

	public static void main(String[] args) {
//		Employee m = new Manager("James", new MyDate(1990, 1, 1), 40000.0, "IT");
//		Employee eg = new Engineer("Tomas", new MyDate(1980, 2, 18), 32000.0, "Java", 30000.0);
//		Employee s = new Secretary("Adams", new MyDate(1995, 5, 2), 60000.0, "IT");
		
		
		// 이기종간의 타입을 하나의 리스트에 넣을 수 있다.
		// 부모 타입에서 관리를 함
		Employee[] emps = {
				new Manager("James", new MyDate(1990, 1, 1), 40000.0, "IT"),
				new Engineer("Tomas", new MyDate(1980, 2, 18), 32000.0, "Java", 30000.0),
				new Secretary("Adams", new MyDate(1995, 5, 2), 60000.0, "IT"),
				new Engineer("Tomas", new MyDate(1980, 2, 18), 15000.0, "Java", 30000.0)
		};
		
		System.out.println("=== 정보를 출력합니다 ===");
		
		for (Employee e : emps) {
			System.out.println(e);
		}
		
		System.out.println("\n=== 정보를 출력합니다 ===");
		
		for (Employee e : emps) {
			double annualSalary = 0.0;

			if (e instanceof Engineer) {
				annualSalary = e.getSalary() * 12 + ((Engineer)e).getBonus(); // Object Casting
			} else {
				annualSalary = e.getSalary() * 12;
			}
			System.out.println(e.getName() + "님의 연봉은 " + annualSalary);
		}

	}

}
