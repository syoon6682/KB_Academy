package com.edu.parent;

import com.edu.util.MyDate;

public class Employee {
	private String name;
	private MyDate birthday;
	private double salary;
	
	public Employee(String name, MyDate birthday, double salary) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getDetails() {
		return "name=" + name + ", birthday=" + birthday + ", salary=" + salary;
	}
	
	
	
}
