package com.edu.algo;

import java.util.Scanner;
import java.util.Arrays;

public class BJ15657_N과_M_8 {
	
	static int M;
	static int[] result;
	static int[] array;
	
	public static void dfs(int i) {
		if (i == M) {
			for(int j=0; j<M; j++) {
				System.out.print(result[j] + " ");
			}
			System.out.println();
		}
		else {
			for(int a: array) {
				if (i == 0 || result[i-1] <= a) {
					result[i] = a;
					dfs(i+1);
					result[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		array = new int[N];
		result = new int[M];

		
		for(int i=0; i<N; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		
		dfs(0);
		}

}
