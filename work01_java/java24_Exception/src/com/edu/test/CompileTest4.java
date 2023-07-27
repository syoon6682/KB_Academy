package com.edu.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ZeroBoom extends Exception {
	
	public ZeroBoom(){
		this("This is ZeroBoom Exception");
	};	
	public ZeroBoom(String message){
		super(message);
	};
	
}

class User{
	public void go() throws ZeroBoom {
		int i = 10;
		int j = 0;
		
		System.out.println("2. go() 진입");
		// 저 밑에 어느 부분에서 연산 진행...i/j...j에 0값이 할당되면 안돼..
		// 만약에 j가 0이라면 Exception을 발생시킴
		if(j==0) throw new ZeroBoom("분모가 0이면 안됩니다~~");
		
		System.out.println("ArithmeticException 터짐");
	}
}

public class CompileTest4 {
	// 여기서 푹탄을 넘기면 JVM으로 넘겨서 JVM이 해결함
	// 폭탄은 JVM이 해결했다고!
	public static void main(String[] args) throws ZeroBoom {
		User u = new User();
		System.out.println("1. go 호출");
		try {
			u.go();
		} catch (ZeroBoom e) {
			System.out.println(e.getMessage());
		}
		
	}

	// 그러나 이 코드의 문제는 close를 해결하지 못함
	// 그래서 실행 코드에서 close를 일일이 해주어야함
}
