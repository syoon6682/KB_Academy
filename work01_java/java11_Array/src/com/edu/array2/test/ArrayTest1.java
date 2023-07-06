package com.edu.array2.test;
/*
 * stack 영역에서의 참조가 끊어진 객체를 쓰레기 객체라 한다.
 * 쓰레기 객체는 더 이상 객체로서의 효용가치가 없기 때문에 GC(Garbage Collector)의 제거 대상이 된다.
 * GC는 내부적으로 우선순위 1짜리 Thread로 작동...알아서 메모리 제거를 관리한다.
 */
public class ArrayTest1 {

	public static void main(String[] args) {
		// 배열 선언 + 생성 + 초기화
		int[] arr1 = {11, 22, 33};
		int[] arr2 = {100, 200, 300};
		
		// 배열 안에 있는 값들을 반복문을 통해서 출력
		for(int i : arr1) System.out.println(i);
		for(int j : arr2) System.out.println(j);
		
		System.out.println("======================================");
		arr1 = arr2;
		for(int i : arr1) System.out.println(i);
		for(int j : arr2) System.out.println(j);
		
	}

}
