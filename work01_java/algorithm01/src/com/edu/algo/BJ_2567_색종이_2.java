package com.edu.algo;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;




public class BJ_2567_색종이_2 {

	public static int checker(int[][] map, int x, int y) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		int cnt = 0;
		
		for(int i=0; i<4; i++) {
			int new_x = x+dx[i];
			int new_y = y+dy[i];
			if (new_x>=0 & new_x<101 & new_y>=0 & new_y<101) {
				if (map[new_x][new_y] == 0) {
					cnt += 1;
				}
			}
		}
		
		return cnt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] paper = new int[101][101];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(temp.nextToken());
			int y = Integer.parseInt(temp.nextToken());
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
					paper[j][k] = 1;
				}
			}		
		}
		
		int cnt = 0;
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(paper[i][j] == 1) {
					cnt += checker(paper, i, j);
				}
			}
		}
		
		System.out.println(cnt);
		
		
	}

}
