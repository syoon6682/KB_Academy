package com.edu.array2.test;
/*
 * 배열의 특징
 * 1. 여러 개의 값을 하나로 묶는 객체...Same Data Type이 전제
 * 2. 배열은 사이즈를 변경할 수 없다. (Resizing이 불가)
 * 3. 사이즈가 다른 배열의 element값을 copy할 수는 있다. (부분 copy, 전체 copy 모두 가능)
 * 4. 배열은 클래스타입이 존재하지 않는 객체이다.
 */

class Person{
	String name;
	int age;
}

public class ArrayTest3 {

	public static void main(String[] args) {
		int[] target = {1, 2, 3, 4, 5, 6};
		int[] source = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		// 사이즈가 다른 배열 source의 내용을 copy해서 target 값 변경
		// 8, 7, 6, 5, 4, 3이 되도록 합니다. System.arraycopy()
		
		System.arraycopy(source, 2, target, 0, target.length);
		for(int t: target) System.out.println(t);
		System.out.println("=======================");
		
		Person p = new Person();
		System.out.println("p: " + p);
		// com.edu.array2.test.Person@626b2d4a -> 얘가 풀네임 -> FQCN(Full Qualified Class Name)
		System.out.println(target);
	}

}
