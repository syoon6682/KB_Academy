package com.edu.test;

/*
 static 키워드와 가장 많이 함께 쓰이는 키워드는 final
 Usage Modifier
 static final -> 좀더 많이 쓰임
 final static
 
 final :: "내가 마지막이야~~~"
 final + 변수 -> 내가 마지막 변수야! -> 상수
 final + 메소드 -> 내가 마지막 메소드야! -> 부모 클래스에서 절대 바꿔서 쓰면 안되는 메소드 -> 오버라이딩 금지
 final + 클래스 -> 내가 마지막 클래스야! -> 상속 금지!
 -> 나머진 안돼!
 */

class A{
	public final static int BASIC_SALARY = 30000;
	public final String test() {
		return "오버라이딩 금지";
	}
}

final class B{
	
}

//class C extends B {
//	
//}

class D extends A{
//	public final String test() {
//		
//	}
	
//	BASIC_SALARY = 500000;
}

public class StaticExamTest3 {
	public static void main(String[] args) {
		
	}
}
