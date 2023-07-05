package com.edu.condition.test;

import java.util.Scanner;

public class switchGradeTest3 {

	public static void main(String[] args) {
		System.out.println("성적입력 >> ");
		Scanner sc = new Scanner(System.in);
		
		int grade = sc.nextInt();
		switch(grade) {
		case 95:
		case 90:
		case 85:
			System.out.println("A...");
//		break; // 여기 주석 처리 유무로 한번 break 확인하기!
		case 80:
		case 75:
			System.out.println("B...");
			break;
		case 60:
		case 65:
			System.out.println("C...");
			break;
		default:
			
		}

	}

}
