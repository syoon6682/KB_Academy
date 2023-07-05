package com.edu.test;

import java.util.Scanner;

/*
 * 지금까지 우리가 작성한 코드를 보면,
 * 실제값이 컴파일 시점에서 입력이 되었다.
 * 
 * 실행 시점에서 실제값을 입력하기 위해서는 Scanner를 사용해야 한다.
 * 
 * Scanner 생성하는 방법은 과연 어떻게 알 수 있을까?
 * Scanner sc = new Scanner(System.in);
 * Document의 instruct summary를 읽고 이해할 줄 알아야함!
 * 
 * 실행시 값을 입력받는 방법
 * 1. 키보드로 입력
 * Scanner sc = new Scanner(System.in);
 * 
 * 2. 파일의 값을 입력
 * Scanner sc = new Scanner(new File("input.txt"));
 * 
 * System.out ---> OutputStream(콘솔)
 * System.in ---> InputStream(키보드)
 * 
 * :: 
 * nextInt()
 * - 공백을 기준으로 값을 반환
 * - Enter를 치더라도 Enter값을 없애고 해당 라인에 커서가 위치한다.
 * - int에 해당하는 정수값을 받아온다.
 */

public class ScannerTest1 {

	public static void main(String[] args) {
		
		// 키보드로 입력되는 값을 받아오는 Scanner 생성
		Scanner sc = new Scanner(System.in);
		System.out.println("input please");
		
		// 정수값을 입력받는 기능
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.println("숫자값1: " + num1 + "\n" + "숫자값2: " + num2);
		System.out.printf("%d %d", num1, num2);
	}

}