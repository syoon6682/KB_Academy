package com.edu.domain;

import com.edu.util.MyDate;

// 직원에 대한 정보를 저장하는 클래스
/*
 * 접근하는 범위를 지정하는 키워드
 * <<Access Modifier>> (접근지정자)
 * private : 범위가 같은 클래스 안에서만 접근을 허용
 * +
 * protected (상속과 연결이 되어 있는 친구)
 * +
 * public: 어디서든지 접근을 허용
 * 
 * 생성자 Overloading
 * ::
 * 필수적인 정보로만 객체를 생성
 * 미처 입력되지 않은 정보는 기본값으로 채울 때 반드시 필요한 기법
 * 이때 다른 생서아를 호출하기 위한 this 키워드를 사용한다!!
 */


/*
 * 다양한 상황에서의 데이터 입력을 위해 생성자  Overloading을 해야함
 */

public class Employee {
	private String name;
	private double salary;
	private MyDate birthDate;
	
	// salary의 기본값 지정...(상수로 지정)
	// final = 이건 절대 바꾸면 안돼! -> 상수!
	// convention은 전부 대문자!
	public static final double BASIC_SALARY = 100.0;

	public Employee() {}
	
	public Employee(String name, double salary, MyDate birthDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	
	
	/*
	 * 생성자 앞에 this
	 * ::
	 * 같은 클래스 내에서 또 다른 생성자를 호출 할 때 사용하는 키워드
	 */
	public Employee(String name, MyDate birthDate) {
		this(name, 100.0, birthDate);
	}
	
	
	@Override
	public String toString() {
		return name + "\t" + salary + "\t" + birthDate.toString();
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}
		
		
		
}
