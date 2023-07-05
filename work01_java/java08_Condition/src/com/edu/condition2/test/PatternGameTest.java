package com.edu.condition2.test;

import java.util.Scanner;

public class PatternGameTest {
	public static String solv(int num) {
		// 코드는 여기서 구현...
		int ten = num/10;
		int one = num%10;
		
		String result = "";
		
		if (ten%3 == 0) {
			result += "@";
		}
		if (one%3 == 0) {
			result += "@";
		}
		
		if (result == "") {
			return String.valueOf(num);
		} else {
			return result;
		}
	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String answer = solv(n);
		System.out.println(answer);

	}

}
