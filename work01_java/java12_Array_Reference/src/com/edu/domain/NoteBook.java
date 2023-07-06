//package 선언부분이 가장 처음에 나옵니다.
//package 는 무조건 소문자, 키워드는 제외, .를 기준으로 상위,하위가 나뉜다.

package com.edu.domain;

import java.util.Vector;

public class NoteBook {

	public String brand;
	public int price;
	public int serialNumber;
	//public Vector v; //lava.lang 패키지에서 제공되는 api 가 아님
	
	/*
	 * this
	 * 로컬변수와 필드를 구분하기 위한 키워드로
	 * 필드 앞에 붙여준다.
	 * ::
	 * this 키워드는 자기자신을 참조하는 주소값을 가지고 있다
	 */
	public NoteBook(String brand, int price, int serialNumber) {
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	//기본생성자 추가...
	public NoteBook() {}
	
	
	
	public String getNoteBookInfo() {
		return brand+
			   "\t"+price+
			   "\t"+serialNumber;
	}		
	
	@Override
	public String toString() {
		return brand+
				   "\t"+price+
				   "\t"+serialNumber;
	}

}//class닫고

















