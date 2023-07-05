package com.edu.array.test;

/*
 * 1. 배열은 객체다!
 * 2. 같은 데이터 타입끼리만 묶을 수 있다! Python이 그리워지네요..
 * -> Same Data Type의 서로 다른 값들을 하나로 묶을 수 있다 -> 이것이 Array라는 객체
 * 
 * Array는 
 * 1) 선언	2) 생성	3) 초기화
 */

public class BasicArrayTest1 {

	public static void main(String[] args) {
		
		// 1. 선언
		int[] arr; // dataType + 변수명;
		
		// 2. 생성(이때 size를 반드시 명시, new라는 키워드로 생성)
		arr = new int[3]; // 이때 묵시적으로 0, 0, 0이 채워짐, 주소값이 생김
		
		// 3. 초기화
		arr[0] = 11; arr[1] = 22; arr[2] = 33;
		
		for(int i=0; i<3; i++) {
			System.out.println(arr[i]);
		}
	
	}

}
