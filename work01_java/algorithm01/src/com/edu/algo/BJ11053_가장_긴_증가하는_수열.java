package com.edu.algo;

import java.util.Arrays;
import java.util.Scanner;

public class BJ11053_가장_긴_증가하는_수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int[] memo = new int[N+1];
		for(int i=1; i<N+1; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<N+1; i++) {
			int global=0;
			int local=0;
			for(int j=i-1; j>=0; j--) {
				if (arr[j] < arr[i]) {
					local = memo[j] + 1;
					if (local > global) {
						global = local;
					}
				}
			}
			memo[i] = global;
		}
		
		int answer = 0;
		for(int m: memo) {
			if (m > answer) {
				answer = m;
			}
		}
		
		System.out.println(answer);
	}

}
