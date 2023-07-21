package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14888_연산자_끼워넣기 {
	
	static int N;
	static int[] arr;
	static int[] oper;
	static int globalMin;
	static int globalMax;
	
	static void dfs(int n, int local) {
		if (n==N) {
			if (local < globalMin) {
				globalMin = local;
			}
			if (local > globalMax) {
				globalMax = local;
			}
			return;
		}
		
		if (n==0) {
			local += arr[n];
			dfs(n+1, local);
		} else {
			for (int i=0; i<4; i++) {
				if (oper[i] != 0) {
					oper[i] -= 1;
					if(i==0) {
						local += arr[n];
						dfs(n+1, local);
						local -= arr[n];
					} else if(i==1) {
						local -= arr[n];
						dfs(n+1, local);
						local += arr[n];
					} else if(i==2) {
						local *= arr[n];
						dfs(n+1, local);
						local /= arr[n];
					} else if(i==3) {
						int temp = local;
						local /= arr[n];
						dfs(n+1, local);
						local = temp;
					}
					oper[i] += 1;
				}
			}
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		arr = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		oper = new int[4];
		
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st3.nextToken());
		}
		
		globalMax = -1000000000;
		globalMin = 1000000000;
		
		dfs(0, 0);
		
		
		System.out.println(globalMax);
		System.out.println(globalMin);
	}	

}
