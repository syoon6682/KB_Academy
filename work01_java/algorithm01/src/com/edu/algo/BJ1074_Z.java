package com.edu.algo;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1074_Z {
	
	static int[][] map;
	static int N;
	static int r;
	static int c;
	static int cnt;
	
	static void Z(int x, int y, int n) {
		if (map[r][c] != 0) {
			return;
		}
		
		if (n == 2) {
			map[x][y] = cnt++;
			map[x][y+1] = cnt++;
			map[x+1][y] = cnt++;
			map[x+1][y+1] = cnt++;
		} else {
			Z(x, y, n/2);
			Z(x, y+n/2, n/2);
			Z(x+n/2, y, n/2);
			Z(x+n/2, y+n/2, n/2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		int len = (int) Math.pow(2, N);
		
		map = new int[len][len];
		cnt = 0;
		
		if (r==0 && c==0) {
			System.out.println(cnt);
		} else {
			Z(0, 0, len);
			System.out.println(map[r][c]);
		}
		
		

	}

}
