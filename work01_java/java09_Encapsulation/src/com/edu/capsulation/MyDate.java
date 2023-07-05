package com.edu.capsulation;

/*
 * 오늘 날짜를 저장하는 클래스
 * valid 값만 month, day에 할당되도록 사용
 * month 1~12사이의 값만 필드 초기화... / "Invalid Month"
 * day 1. 3  5 , 7, 8, 1월 day - 1~31일
 * 4, 6, 9, 11 1~30dlf
 * 2월 day 1~28일
 */

public class MyDate {
	private int month;
	private int day;
	
	
	
	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		// 제어문 적용
		if (month >= 13 || month < 1) {
			this.month = 0;
		} else {
			this.month = month;
			}
		
	}



	public int getDay() {
		return day;
	}



	public void setDay(int day) {
		// 제어문 적용
//		if (this.month == 0) {
//			this.day = 0;
//		} else if(day >= 1 & day <=28) {
//			this.day = day;
//		} else if ((day == 29 || day == 30) & this.month != 2) {
//			this.day = day;
//		} else if ((day == 31)  & (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12)) {
//			this.day = day;
//		} else {
//			this.day = 0;
//		}
		
		// switch version
		switch(month) {
		case 2:
			if(true) {
				
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if(true) {
				
			}
			break;
		default: // 가장 많이 활용되는 월(1, 3, 5, 7, 8, 10, 12)를 default로 넘김
			break;
		}
		
		
	}



	public String getDate() {
		return "Today is " + month + "-" + day;
	}
}
