package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2630_색종이_만들기 {
	static int N;
	static int[][] paper;
	static int zero;
	static int one;
	
	
	static void divide(int x, int y, int n) {
		int std = paper[x][y];
		boolean same = true;
		
		for (int i=x; i<x+n; i++) {
			for (int j=y; j<y+n; j++) {
				if (paper[i][j] != std) {
					same = false;
				}
				if (!same) {
					break;
				}
			}
			if (!same) {
				break;
			}
		}
		
		if(same) {
			if (std == 0) {
				zero++;
			} else {
				one++;
			}
		} else {
			divide(x, y, n/2);
			divide(x, y+n/2, n/2);
			divide(x+n/2, y, n/2);
			divide(x+n/2, y+n/2, n/2);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		paper = new int[N][N]; 
		
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		
		divide(0, 0, N);
		System.out.println(zero);
		System.out.println(one);
	}

}
