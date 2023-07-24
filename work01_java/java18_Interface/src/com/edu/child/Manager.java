/*

Employee
	|
Manager
상속관계 시 중요한 지점

1. 자식 객체 생성시 무조건 부모 객체를 먼저 생성
2. 부모에게 물려받는 필드에 값 주입은 super() 혹은 super.setXxx 사용
3. 부모에게 물려받은 메소드는 자식클레스에서 구현부를 자식에게 맞게 고쳐쓴다.
	메소드 오버라이딩
	선언부는 모두 일치
	구현부는 반드시 다르게 구현한다.
 */

package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

//Child Class..

public class Manager extends Employee{
	
	private String dept;
//
//	public Manager(String dept) {
//		// 자식이 생성되려면 반드시 부모가 먼저 생성되어야 한다. -> 무조건!
//		// 자식 생성자 첫 라인에서 무조건 부모 생성자 호출이 일어난다.
//		// (부모 기본 생성자 호출|부모 명시적 생성자 호출)
//		super();
//		this.dept = dept;
//	}
//	


	public Manager(String name, MyDate birthday, double salary, String dept) {
		
		// 생성자 안에서 필드 초기화 진행
		super(name, birthday, salary); // 부모 필드 값 주입
		this.dept = dept; // 자식 필드 값 주입
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", dept = " + dept;
	}


	public String getDept() {
		return dept;
	}


	public void changeDept(String dept) {
		this.dept = dept;
	}
	
	
}
