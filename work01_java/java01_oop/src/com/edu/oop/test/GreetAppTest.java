package com.edu.oop.test;

import com.edu.oop.Greet;

/*
 * main 메소드가 있으면 실행 / Test class
 * ~Test 클래스가 하는 일
 * 1) 변수에 값을 입력
 * 2) 메소드는 호출
 */
public class GreetAppTest {

	public static void main(String[] args) {
		Greet g = new Greet();
		// 초기화 -> 새로운 값 할당을 초기화, 변수에 처음 넣는 걸 초기화라고 하는게 아녀~
		// 변수 초기화(Initialization)
		g.target = "KB IT`s life 4기";
		g.message = "Hello Java~~!";
		
		// 메소드 호출
		g.sayHello();
	}

}
