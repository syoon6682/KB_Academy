package com.edu.cons.test;


class Date{
	int year;
	int month;
	int day;
	
	// 명시적 생성자
	public Date(int year, int month, int day) {
		// 필드 초기화....주입의 통로를 생성자로 결정
		
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	
	/*
	 * String + Non-String ==> String화
	 */
	public String getDate() {
		return year + "-" + month + "-" + day;
	}
}


class WhiteBoard{
	
	// 1. 필드 선언
	String madeCompany;
	float price;
	boolean scratch;
	char size;
	// 추가...제조일자
	Date madeDate;
	
	//2. 필드 주입 기능 정의(void | 인자값이 있어야함!)
	public void setWhiteBoard(String madeCompany, float price, boolean scratch, char size, Date madeDate) {
		
		// 필드초기화
		this.madeCompany = madeCompany;
		this.price = price;
		this.scratch = scratch;
		this.size = size;
		this.madeDate = madeDate;
	}
	
	// 3. 주입된 필드값을 반환
	public String getWhiteBoard() {		
		return madeCompany + ", " + price + ", " + scratch + ", " + size + ", " + madeDate.getDate();
	}
}


public class WhiteBoardTest {

	public static void main(String[] args) {
		// 객체 생성...new...메모리에 로딩
		WhiteBoard wb = new WhiteBoard();
		
		
		// 1. set~~~() 호출...필드값이 채워진다.
		// 인자값의 갯수, 순서, 타입이 일치해야한다.
		
		// 시간은 고정이므로 이런 식으로 생성자 활용하는 것이 좋음!
		wb.setWhiteBoard("동신사", 34000.0F, false, 'L', new Date(2023, 07, 04));
		
		// 2. System.out.println(get~~() 호출)
		System.out.println(wb.getWhiteBoard());

	}

}
