package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

//Child Class..

public class Manager extends Employee{
	
	private String dept;

	public Manager(String name, MyDate birthday, double salary, String dept) {
		
		// 생성자 안에서 필드 초기화 진행
		super(name, birthday, salary); // 부모 필드 값 주입
		
		this.dept = dept; // 자식 필드 값 주입
	}
	
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails() + "dept = " + dept;
	}
}
