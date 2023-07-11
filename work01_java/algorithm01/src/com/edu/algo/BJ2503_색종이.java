package com.edu.algo;

import java.util.Scanner;

public class BJ2503_색종이 {

	public static void main(String[] args) {
		int[][] paper = new int[101][101];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					paper[j][k] = 1;
				}
			}
		}
		
		
		int cnt = 0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if (paper[i][j] == 1) cnt+=1;
			}
		}
		System.out.println(cnt);
	}
}
