package com.edu.algo;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class SWEA_2001
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N+1][N+1];
			
			for(int i = 1; i < N+1; i++) {
				for(int j = 1; j < N+1; j++) {
						map[i][j] = map[i][j-1] + sc.nextInt();
				}
			}
			
			for(int i = 1; i < N+1; i++) {
				for(int j = 1; j < N+1; j++) {
					map[j][i] += map[j-1][i];
				}
			}
			
			int global = 0;
			int local = 0;
			
			for(int i = M; i < N+1; i++) {
				for(int j = M; j < N+1; j++) {
					local = map[i][j] - map[i-M][j] - map[i][j-M] + map[i-M][j-M];
					if (local > global) {
						global = local;
					}
				}
			}
			
//			System.out.println(Arrays.deepToString(map));
			System.out.println("#"+ test_case + " " + global);
		}
	}
}