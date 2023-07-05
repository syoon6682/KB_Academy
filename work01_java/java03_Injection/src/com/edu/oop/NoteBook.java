package com.edu.oop;

/*
 * NoteBook에 대한 정보를 저장하는 클래스
 */

public class NoteBook { // 사용자 정의 클래스
	
	// 필드 선언
	public String brand;
	public Integer price;
	public Integer serialNumber; // Java는 꼭 CamelCase로!
	
	// 메소드는 return type을 가짐
	// return type이 void이면 반환값이 없다는 의미의 return type
	// 반환값을 String으로 지정
	// 호출한 곳에서 return함
	public String getNoteBookInfo() {
		return brand + "\t" + price + "\t" + serialNumber;
	}
	
	// 필드에 값 주입(값 할당) == 필드초기화
	public void setNoteBook(String brand, int price, int serialNumber) {
		
		this.brand = brand;
		this.price= price;
		this.serialNumber = serialNumber;
	}
}
