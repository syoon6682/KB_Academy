package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2239_스도쿠 {

	static int[][] map;
	static int zero = 0;
	
	static boolean flag = false;
	
	static int[] boxCheck(int[] check, int x, int y) {
		for (int i=x-3; i<x;i++) {
			for(int j=y-3; j<y; j++) {
				check[map[i][j]] = 1;
			}
		}
		
		return check;
	}
	
	static int[] checker(int x, int y) {
		int[] check = new int[10];
		for(int i: map[x]) {
			check[i] = 1;
		}
		for(int i=0; i<9; i++){
			check[map[i][y]] = 1;
		}
		
		if (x<3 && y<3) {
			check = boxCheck(check, 3, 3);
		} else if (x<3 && y>=3 && y<6) {
			check = boxCheck(check, 3, 6);
		} else if (x<3 && y>=6 && y<9) {
			check = boxCheck(check, 3, 9);
		} else if (x>=3 && x<6 && y<3) {
			check = boxCheck(check, 6, 3);
		} else if (x>=3 && x<6 && y>=3 && y<6) {
			check = boxCheck(check, 6, 6);
		} else if (x>=3 && x<6 && y>=6 && y<9) {
			check = boxCheck(check, 6, 9);
		} else if (x>=6 && x<9 && y<3) {
			check = boxCheck(check, 9, 3);
		} else if (x>=6 && x<9 && y>=3 && y<6) {
			check = boxCheck(check, 9, 6);
		} else if (x>=6 && x<9 && y>=6 && y<9) {
			check = boxCheck(check, 9, 9);
		}
		
		return check;
	}
	
	static void dfs(int n) {
		if (n==zero) {
			flag = true;
			return;
		}
		if (flag) return;
		
		
		for(int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (map[i][j] == 0) {
					int[] test = checker(i, j);
					for(int k=1; k<10; k++) {
						if (test[k] == 0) {
							map[i][j] = k;
							dfs(n+1);
							if (flag) return;
							map[i][j] = 0;
						}
					}
					return;
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		
		for (int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for (int j=0; j<9; j++) {
				map[i][j] = Character.getNumericValue(temp.charAt(j)); 
				if(map[i][j] == 0) {
					zero++;
				}
			}
		}

		dfs(0);

		for(int i=0; i<9; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j=0; j<9; j++) {
				sb.append(map[i][j]);
			}
			System.out.println(sb);
		}

	}

}
