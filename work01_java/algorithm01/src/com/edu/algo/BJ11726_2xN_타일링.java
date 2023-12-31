package com.edu.algo;

import java.util.Scanner;

public class BJ11726_2xN_타일링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		for (int i=2; i<n+1; i++) {
			arr[i] = (arr[i-1] + arr[i-2])%10007;
		}
		
		System.out.println(arr[n]);
	}

}
