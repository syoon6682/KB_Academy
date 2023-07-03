package com.edu.oop;

/*
 * 1. Member variable == field
 * (브랜드, 가격, sn)
 * 2. Method
 * 정보를 출력하는 기능
 * printNoteBookInfo()
 */

public class NoteBook { // 사용자 정의 클래스
	
	// 필드 선언
	public String brand;
	public Integer price;
	public Integer serialNumber; // Java는 꼭 CamelCase로!
	
	// Method 정의
	public void printNoteBookInfo() {
		System.out.println("Brand: " + brand);
		System.out.println("Price: " + price);
		System.out.println("Serial Number: " + serialNumber);
		// \t 활용해서 한줄에 가능!
	}
}

// String, System과 같은 클래스 -> 다른 개발자가 만들고 실행 파일의 형태로 제공(JDK 안에 이미 빌트인) -> 라이브러리 / API -> 라이브러리가 모이면 Framework