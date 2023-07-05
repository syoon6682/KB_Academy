package com.edu.array.test;

/*
 * 1. 배열은 객체다!
 * 2. 같은 데이터 타입끼리만 묶을 수 있다! Python이 그리워지네요..
 * -> Same Data Type의 서로 다른 값들을 하나로 묶을 수 있다 -> 이것이 Array라는 객체
 * 
 * Array는 
 * 1) 선언	2) 생성	3) 초기화
 */

public class BasicArrayTest3 {

	public static void main(String[] args) {
		
		// 1. 선언 + 2. 생성 + 3. 초기화
		int[] arr = {11, 22, 33};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	
	}

}
