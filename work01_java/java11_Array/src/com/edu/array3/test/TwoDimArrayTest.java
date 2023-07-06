package com.edu.array3.test;

public class TwoDimArrayTest {

	public static void main(String[] args) {
		// 2행 3열의 2차원 배열이 만들어짐
		int[][] twoArr = new int[2][3];
		System.out.println(twoArr.length); // 2
		System.out.println(twoArr[0].length); // 3
		System.out.println(twoArr[0].length); // 3
		
		for (int i=0; i < twoArr.length; i++) {
			for (int j=0; j < twoArr[0].length; j ++) {
				System.out.println(twoArr[i][j]+" ");
			}
			System.out.println("");
		}
		
		System.out.println("=========================");
		
		int[][] twoArr2 =new int[2][];
		
		twoArr2[0] = new int[3];
		twoArr2[1] = new int[6];
		System.out.println(twoArr2[0].length);
		System.out.println(twoArr2[1].length);
	}

}
