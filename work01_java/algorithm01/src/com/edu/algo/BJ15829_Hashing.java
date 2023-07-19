package com.edu.algo;

import java.util.Arrays;
import java.util.Scanner;

public class BJ15829_Hashing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String w = sc.next();
		long local = 0;
		long[] arr = new long[L];
		arr[0] = 1;
		for (int i=1; i<L; i++) {
			long temp = arr[i-1] * 31;
			if (temp >= 1234567891) {
				arr[i] = temp % 1234567891;
			} else {
				arr[i] = temp;
			}
		}
		
		for(int i=0; i<L; i++) {
			local += ((Character.getNumericValue(w.charAt(i))-9) * arr[i]);
			local %= 1234567891;
		}
		System.out.println(local);
	}
	
}
