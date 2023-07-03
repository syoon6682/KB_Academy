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
	
	// 필드에 값할당하는 기능을 추가 == 주입(set~~~)
	public void setNoteBook(String brand, int price, int serialNumber) {
		// 필드와 로컬변수를 구분하기 위해 this 키워드를 필드 앞에 붙여야 함!
		this.brand = brand;
		this.price= price;
		this.serialNumber = serialNumber;
	}
}
