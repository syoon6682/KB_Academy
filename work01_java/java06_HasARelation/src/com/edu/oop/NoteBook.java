// package 선언 부분이 가장 처음에 나옵니다. 
// package는 무조건 소문자, 키워드느 제외, .을 기준으로 상위, 하위가 나뉨
package com.edu.oop;

//import java.util.Vector;

/*
 * NoteBook에 대한 정보를 저장하는 클래스
 */

/*
 * this
 * 로컬변수와 필드를 구분하기 위한 키워드로
 * 필드 앞에 붙여준다.
 * ::
 * this 키워드는 자기자신을 참조하는 주소값을 가지고 있다.
 */

public class NoteBook { // 사용자 정의 클래스
	
	// 필드 선언
	public String brand;
	public Integer price;
	public Integer serialNumber; // Java는 꼭 CamelCase로!
	//	public Vector v; //java.lang 패키지에서 제공하는 API가 아님 -> import 해야함!
	
	// 메소드는 return type을 가짐
	// return type이 void이면 반환값이 없다는 의미의 return type
	// 반환값을 String으로 지정
	// 호출한 곳에서 return함
	public String getNoteBookInfo() {
		return brand + "\t" + price + "\t" + serialNumber;
	}
	
	// 하나의 클래스에서는 반드시 하나 이상의 생성자가 존재한다.
	// 명시적 생성자가 정의되어져 있지 않을때 무조건 기본 생성자를 넣어준다. -> 컴파일러가!
	// 만약에 명시적 생성자가 하나라도 정의되었으면 그때는 자동으로 기본 생성자를 넣어주지 않음
	// 이렇게 동일한 이름에 서로 다른 인자를 받는 복수의 생성자 생성을 Overloading이라고 함!!
	public NoteBook(String brand, Integer price, Integer serialNumber) {
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	public NoteBook() {
	}
}
