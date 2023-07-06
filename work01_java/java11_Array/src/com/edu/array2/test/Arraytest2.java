package com.edu.array2.test;
/*
 * 주소값이 다르면 다른 객체
 * 주소값이 같으면 같은 객체
 */
public class Arraytest2 {

	public static void main(String[] args) {
		int[] member = {1, 2, 3, 4, 5};
		// 배열은 resizing이 안됨
		// 끊어진 길이 5의 배열은 GC의 대상이 됨
		member = new int[8];
		member[5] = 6;
		member[6] = 7;
		member[7] = 8;
		for(int i : member) System.out.println(i);
		// 0, 0, 0, 0, 0, 6, 7, 8
		
	}

}
