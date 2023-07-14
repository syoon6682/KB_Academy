package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ12865_평범한_배낭 {
	
	static int N;
	static int K;
	static int[][] bag;
	static int wSum;
	static int vSum;
	static int global;
	
	
	static void dfs(int idx) {
		if (idx==N) {
			valueChecker(vSum);
		}
		
		for (int i=idx; i<N; i++) {
			wSum += bag[i][0];
			vSum += bag[i][1];
			if (wSum > K) {
				continue;	
			} else {
				dfs(idx+1);
				wSum -= bag[i][0];
				vSum -= bag[i][1];
			}
			valueChecker(vSum);
		}
	}
	
	static void valueChecker(int local) {
		if(local > global) {
			global = local;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bag = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(temp.nextToken());
			int V = Integer.parseInt(temp.nextToken());
			int[] wv = {W, V};
			bag[i] = wv;
		}
		
		global = 0;
		wSum = 0;
		vSum = 0;
		
		dfs(0);
		
		System.out.println(global);
		
			
	}

}