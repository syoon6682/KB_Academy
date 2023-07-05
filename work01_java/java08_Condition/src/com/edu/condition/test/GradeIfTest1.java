package com.edu.condition.test;

import java.util.Scanner;

/*
 * field | local v의 구분
 * 변수가 선언된 위치에 따라 달라진다.
 * 
 * field - 클래스 바로 아래
 * 		   메소드 블럭 바깥
 * 		   기본값을 가진다
 * 		   초기화 안하고 사용해도 에라 안남!!!
 * 
 * local variable - 메소드 블럭 안
 * 					기본값이 없다.
 * 					그래서 초기화를 반드시 해야 한다. -> 안하면 에러남!!
 */

public class GradeIfTest1 {

	public static void main(String[] args) {
		// int grade = 88; // local variable
		Scanner sc = new Scanner(System.in);
		System.out.println("성적 입력");
		int grade = sc.nextInt();
		
		if(grade <= 100 & grade > 80) {
			System.out.println("A Grade...");
		}
		else if (grade >= 70 & grade < 80) {
			System.out.println("B Grade...");
		}
		else if (grade >= 60 & grade < 70) {
			System.out.println("C Grade...");
		}
		else {
			System.out.println("Try again");
		}
		
		
	}

}
