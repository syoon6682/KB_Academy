package com.edu.algo;

import java.util.Scanner;

public class BJ15829_Hashing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String w = sc.next();
		int local = 0;
		int[] arr = new int[L];
		arr[0] = 1;
		for (int i=1; i<L; i++) {
			int temp = arr[i-1] * 31;
			if (temp >= 1234567891) {
				arr[i] = temp - 1234567891;
			} else {
				arr[i] = temp;
			}
		}
		
		for(int i=0; i<L; i++) {
			local += ((Character.getNumericValue(w.charAt(i))-9) * arr[i]);
		}
		System.out.println(local%1234567891);
	}
	
}
