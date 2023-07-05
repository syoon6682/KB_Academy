package com.edu.cons.test;

import com.edu.cons.Shirt;

public class shirtTest {

	public static void main(String[] args) {
		
		/*
		 * s1이라는 객체 생성시 Shirt 클래스는 Type으로 작동
		 * new Shirt() 객체를 생성하면
		 * "Shirt 클래스의 멤버가 메모리에 올라간다"
		 * 
		 * 객체 생성과 동시에 값 주입을 원하면 생성자를 이용
		 */
		
		Shirt s1 = new Shirt();
		
		// 호출이 안된 상황...필드 초기화가 안됨
		// 그러나 에러는 나지 않음 -> 필드에는 기본값(default값)이 들어가 있기 때문이지!
		System.out.println(s1.getShirt());
	}

}
