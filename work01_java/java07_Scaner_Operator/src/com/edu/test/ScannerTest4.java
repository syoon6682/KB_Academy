package com.edu.test;

import java.util.Scanner;

// ~Test3의 문제점을 해결해보자
// nextLine()을 사용한채로!

public class ScannerTest4 {

	public static void main(String[] args) {
		
		// 키보드로 입력되는 값을 받아오는 Scanner 생성
		Scanner sc = new Scanner(System.in);
		System.out.println("input please");
		
		// 정수값을 입력받는 기능
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		sc.nextLine(); //라인을 바꾸는 기능
		String name = sc.nextLine();
		
		System.out.println("숫자값1: " + num1 + "\n" + "숫자값2: " + num2);
		System.out.println(name);
	}

}
