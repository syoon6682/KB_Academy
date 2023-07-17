package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class BJ12865_평범한_배낭 {	

	static int valueChecker() {
		return 1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] bag = new int[N+1][2];
		
		for(int i=1; i<N+1; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			bag[i][0] = Integer.parseInt(temp.nextToken());
			bag[i][1] = Integer.parseInt(temp.nextToken());
		}
		
		int global = 0;
		
		int[][] dp = new int[N+1][K+1];
		
		for (int i=1; i<N+1; i++) {
			int w = bag[i][0];
			int v = bag[i][1];
			for (int j=1; j<K+1; j++) {
				if (j<w) {
					dp[i][j] = dp[i-1][j];
				}
				if (j >= w) {
					if (dp[i-1][j] > v + dp[i-1][j-w]) {
						dp[i][j] = dp[i-1][j];
					} else {
						 dp[i][j] = v + dp[i-1][j-w];
					}
				}
			}
		}
		
		for (int i=0; i<K+1; i++) {
			if(dp[N][i] > global) {
				global = dp[N][i];
			}
		}	
		
		System.out.println(global);
			
	}
}