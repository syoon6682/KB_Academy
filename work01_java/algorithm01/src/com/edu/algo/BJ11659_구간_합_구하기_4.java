package com.edu.algo;

import java.util.Scanner;

public class BJ11659_구간_합_구하기_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] numList = new int[N];
		
		int total = 0;
		for(int i = 0; i<N; i++) {
			int temp = sc.nextInt();
			total += temp;
			numList[i] = total;
		}
		
		for(int i=0; i<M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			if (s==1) {
				int result = numList[e-1];
				System.out.println(result);
			} else {
				int result = numList[e-1] - numList[s-2];
				System.out.println(result);
			}	
		}
	}
}
