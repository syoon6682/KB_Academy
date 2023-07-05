package com.edu.condition.test;

import java.util.Scanner;

/*
 * Scanner를 사용해서 성적과 함께 과목명을 입력
 * Java, A Grade
 */

public class GradeIfTest2 {

	public static void main(String[] args) {
		// int grade = 88; // local variable
		Scanner sc = new Scanner(System.in);
		
		System.out.println("성적 입력");
		int grade = sc.nextInt();
		
		System.out.println("과목 입력");
		String subject = sc.next();
		
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
		
		System.out.println(subject);
		
	}

}
