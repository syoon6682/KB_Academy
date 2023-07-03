package com.edu.oop;
/*
 * 특정한 대상에게
 * 인삿말을 출력하는 기능을 가진 클래스
 * 클래스 구성요소 2개
 * 1) 변수  --- Member Variable
 * 2) 메소드 --- Method
 * ::
 * 쿨래스 작동시키려면? ---->>> 실행 클래스 / Test 클래스
 * 1) 변수 ---> 값을 입력
 * 2) 메소드 ---> 호출 / calling
 
 * 수직적인 관계 -> 상속
 */

public class Greet {
	// 변수 선언 :: 데이터 타입 + 변수 이름
	// 변수는 특정한 값이 들어가는 공간
	public String target;
	public String message;
	
	
	// 메소드 정의 :: 콘솔창 뭔가를 출력 -> 메소드
	public void sayHello() { // 메소드 선언부
		System.out.println(target + ", " + message); //메소드 구현부
	}
	
}
