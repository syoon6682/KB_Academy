package com.edu.algo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;


class SWEA_전자카트
{
	static int[][] map;
	static int N;
	static int global;
	static Stack <Integer> s;
	static int[] check;
	
	static void dfs(int n, int idx) {
		if (n == N) {
			s.add(0);
			routeChecker();
			s.pop();
		}
		else {
			for(int i=idx; i<N; i++) {
				if (check[i] == 1) {
					continue;
				}
				s.add(i);
				check[i] = 1;
				dfs(n+1, idx);
				s.pop();
				check[i] = 0;
				
			}
		}
	}
	
	
	static void routeChecker() {
		int local = 0;
		for(int i=0; i<s.size()-1; i++) {
			local += map[s.get(i)][s.get(i+1)];
		
		}
		if (local < global) {
			global = local;
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
			for (int i=0; i<N;i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			s = new Stack<Integer>();
			s.add(0);
			global = 250000;
			
			dfs(1, 1);
			
			
			System.out.println("#" + test_case + " " + global);
		}
	}
}