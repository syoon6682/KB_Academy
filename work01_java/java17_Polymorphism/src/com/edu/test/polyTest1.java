package com.edu.test;

/*
 * 
 */

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class polyTest1 {

	public static void main(String[] args) {
		Employee m = new Manager("James", new MyDate(1990, 1, 1), 40000.0, "IT");
		Employee eg = new Engineer("Tomas", new MyDate(1990, 1, 1), 40000.0, "Java", 30000.0);
		Employee s = new Secretary("Adams", new MyDate(1990, 1, 1), 40000.0, "IT");
		
		// 1. Jame의 부서를 IT 부서에서 Marketing 부서로 변동 -> changedept() 사용
		
//		Manager m1 = (Manager) m;
//		m1.changeDept("Marketing");
		
		((Manager) m).changeDept("Marketing");
				
		// 2. 정보 출력
		/*
		 Virtual Method Invocation 원리
		 상속관계의 오버라이딩된 메소드에서
		 부모타입으로 자식객체를 생성했을 때 발생하는 원리
		 
		 1. 컴파일 타입 메소드 --- 부모의 메소드 호출
		 2. 런타입 메소드 --- 실질적으로 생성된 자식의 메소드를 호출
		 */
		
		System.out.println(m);
		System.out.println(eg);
		System.out.println(s);
	}

}
