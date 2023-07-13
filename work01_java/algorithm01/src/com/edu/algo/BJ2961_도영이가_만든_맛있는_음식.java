package com.edu.algo;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2961_도영이가_만든_맛있는_음식 {
	
	static int N;
	static int a = 1;
	static int b = 0;
	static int globalMin = -1;
	static int[][] cook;
	
	public static void dfs(int c, int idx, int n) {
		if(c == n) {
			if(globalMin == -1 || globalMin > Math.abs(a-b)) {
				globalMin = Math.abs(a-b);
			} 	
		} else {
			if (idx==N) {
				return;
				} 
			else {
				for(int i=idx; i<N; i++) {
					int x = cook[i][0];
					int y = cook[i][1];
					a *= x;
					b += y;
					dfs(c+1, i+1, n);
					a /= x;
					b -= y;
				}
			}
		}	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		cook = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer stTemp = new StringTokenizer(br.readLine());
			int[] temp = new int[2];
			temp[0] = Integer.parseInt(stTemp.nextToken());
			temp[1] = Integer.parseInt(stTemp.nextToken());
			cook[i] = temp;
		}
		
		
		for(int i=1; i<=N; i++) {
			dfs(0, 0, i);
		}
		System.out.println(globalMin);
	}
}
