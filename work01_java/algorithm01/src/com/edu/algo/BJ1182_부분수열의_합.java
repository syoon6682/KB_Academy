package com.edu.algo;

import java.util.Scanner;

public class BJ1182_부분수열의_합 {
	static int N;
	static int S;
	static int[] arr;
	static int cnt;
	static int sum;
	
	static void dfs(int idx) {
			if (idx == N) {
				return;
			} else {
				for(int i=idx; i<N; i++) {
					sum += arr[i];
					if (sum==S) {
						cnt += 1;
						}
					dfs(i+1);
					sum -= arr[i];
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		arr = new int[N];
		for(int i=0; i<N;i++) {
			arr[i] = sc.nextInt();
		}
		cnt = 0;
		sum = 0;
		
		dfs(0);
		System.out.println(cnt);
	}
}
