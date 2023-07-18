package com.edu.algo;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class SWEA_5209
{
	
	static int[][] map;
	static int N;
	static int[] check;
	static int global;
	
	static void dfs(int n, int local) {
		if(n==N) {
			if (local < global) {
				global = local;
			}
		} 
		
		if (local > global) {
			return;
		}
		
		else {
			for (int i=0; i<N; i++) {
				if(check[i] == 1) {
					continue;
				}
				check[i] = 1;
				local += map[n][i];
				dfs(n+1, local);
				local -= map[n][i];
				check[i] = 0;
				
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			map = new int[N][N];
			check = new int[N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			global = 1500;
			
			dfs(0,0);
			System.out.println("#" + test_case + " " + global);
			
		}
	}
}