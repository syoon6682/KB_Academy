package com.edu.algo;
import java.util.Scanner;
import java.io.FileInputStream;


class SWEA_장훈이
{
	
	static int N;
	static int B;
	static int[] arr;
	static int global;
	
	static void dfs(int n, int local) {
		if (n==N) {
			if (local - B >= 0 && local -B< global) {
				global = local - B;
			}
			return;
		}
		if (local - B > global) {
			return;
		}
		
		else {
			dfs(n+1, local);
			dfs(n+1, local+arr[n]);
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
			B = sc.nextInt();
			arr = new int[N];
			global = 0;
			
			for (int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				global += arr[i];
			}
			
			dfs(0, 0);
			
			System.out.println("#" + test_case + " " + global);
			

		}
	}
}