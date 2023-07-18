package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Stack;

public class BJ14889_스타트와_링크 {
	
	static int N;
	static int[][] team;
	static int totalSum;
	static int global;
	static Stack<Integer> s = new Stack<>();
	
	static void dfs(int n, int idx) {
		if (n == N/2) {
			checker();
		} else {
			for(int i=idx; i<N; i++) {
				s.add(i);
				dfs(n+1, i+1);
				s.pop();
			}
		}
	}
	
	static void checker() {
		int local1 = 0;
		int local2 = 0;
		HashSet <Integer> hs = new HashSet<>();
		for(int i=0; i<N; i++) {
			hs.add(i);
		}
		
		for(int i:s) {
			hs.remove(i);
		}
		
		for(int i: hs) {
			for(int j: hs) {
				local1 += team[i][j];
			}
		}
		
		for (int i: s) {
			for(int j: s) {
				local2 += team[i][j];
			}
		}
		int answer = Math.abs(local1- local2);
		if (answer < global) {
			global = answer;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		team = new int[N][N];
		
		totalSum = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int pt = Integer.parseInt(temp.nextToken());
				team[i][j] = pt;
				totalSum += pt;
			}
		}
		
		global = totalSum;
		
		dfs(0, 0);
		
		System.out.println(global);
		
	}

}
