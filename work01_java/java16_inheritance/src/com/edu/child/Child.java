package com.edu.child;

import com.edu.parent.Parent;

//자식 클래스
public class Child extends Parent{

	public void test() {
		// 부모클래스(다른 디렉토리, 패키지에 들어있다)의 필드에 접근...
		System.out.println(pulicVar);
		System.out.println(protectedVar);
		
		
		
		// 아래 둘은 범위 제한으로 안됨
//		System.out.println(var);
//		System.out.println(privateVar);
	}
}
