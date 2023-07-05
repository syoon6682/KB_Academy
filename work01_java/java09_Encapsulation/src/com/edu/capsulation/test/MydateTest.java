package com.edu.capsulation.test;

import java.util.Scanner;

import com.edu.capsulation.MyDate;

/*
 * 1. Scanner를 사용해서 month, day값 받아온다.
 */

public class MydateTest {

	public static void main(String[] args) {
		
		MyDate md = new MyDate(); // 기본생성자 calling
		
		/*
		 * 다른 클래스(~~Test)에서 field에 직접적으로 접근을 못하게 함
		 * invalid한 값이 필드에 저장되지 못하게 막아아 한다.
		 */
		
		// 기능을 통해 주입하게 되면 조건문을 할 수 있음
		System.out.println("Please input month and day");
		Scanner sc = new Scanner(System.in);
		
		int inputMonth = sc.nextInt();
		int inputDay = sc.nextInt();
		
		
		md.setMonth(inputMonth);
		md.setDay(inputDay);
		
		
		// 이때 여기 if문을 활용하는 것이 아닌 System.exit을 활용한 system 종료 -> 익숙함을 떠나 새로운 관점에서 해결해보자
		// 그리고 뭔 Switch 활용하라고 거저 준 문제를 if 문으로 풀고 앉아있음ㅋㅋㅋ switch도 언제나 염두에 두며 해보기
		if (md.getMonth() == 0) {
			System.out.println("Invalid Month");
		} else if (md.getDay() == 0) {
			System.out.println("Invalid Day");
		} else {
			System.out.println("Today is " + md.getMonth() + "/" + md.getDay());
		}
	}

}
