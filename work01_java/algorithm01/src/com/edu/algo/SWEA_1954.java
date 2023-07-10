package com.edu.algo;


import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


class SWEA_1954
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			
			int[] arr = new int[2*N-1];
			int idx = 0;
			int point = N;
			
			while (point>0) {
				if (point == N) {
					arr[idx++] = point;
					point -= 1;
				} else {
					arr[idx++] = point;
					arr[idx++] = point;
					point -= 1;
				}
				
			}
			
			int x = 0;
			int y = 0;
			String direc = "R";
			int[][] map = new int[N][N];
			int index = 1;
			for (int a: arr) {
				if (direc == "R") {
					for(int i = 0; i < a; i++) {
						map[x][y++] = index++;
					}
					y--;
					x++;
					direc = "D";
				} else if (direc == "L") {
					for(int i = 0; i < a; i++) {
						map[x][y--] = index++;
					}
					y++;
					x--;
					direc = "U";
					
				} else if (direc == "U") {
					for(int i = 0; i < a; i++) {
						map[x--][y] = index++;
					}
					x++;
					y++;
					direc = "R";
					
				} else if (direc == "D") {
					for(int i = 0; i < a; i++) {
						map[x++][y] = index++;
					}
					x--;
					y--;
					direc = "L";
				}
			}
			System.out.println("#" + test_case);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}