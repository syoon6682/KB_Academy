package com.edu.algo;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */



class SWEA_12712
{	
	public static int spray1(int[][] map, int N, int M, int x, int y) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		int kill = 0;
		
		kill += map[x][y];
		
		for(int i=0; i<4; i++) {
			int new_x = x;
			int new_y = y;
			for(int j=0; j<M-1; j++) {
				new_x += dx[i];
				new_y += dy[i];
				
				if(new_x >=0 & new_x < N & new_y >= 0 & new_y < N) {
					kill += map[new_x][new_y];
				}	
			}	
		}
		
		return kill;
	}
	
	public static int spray2(int[][] map, int N, int M, int x, int y) {
		int[] dx = {1, -1, 1, -1};
		int[] dy = {1, -1, -1, 1};
		int kill = 0;
		
		kill += map[x][y];
		
		for(int i=0; i<4; i++) {
			int new_x = x;
			int new_y = y;
			for(int j=0; j<M-1; j++) {
				new_x += dx[i];
				new_y += dy[i];
				
				if(new_x >=0 & new_x < N & new_y >= 0 & new_y < N) {
					kill += map[new_x][new_y];
				}
				
			}	
		}
		
		return kill;
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int local = 0;
			int global = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					local = spray1(map, N, M, i, j);
					if (local > global) {
						global = local;
					}
					local = spray2(map, N, M, i, j);
					if (local > global) {
						global = local;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + global);
			

		}
	}
}