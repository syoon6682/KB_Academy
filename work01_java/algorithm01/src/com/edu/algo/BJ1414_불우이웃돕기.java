package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1414_불우이웃돕기 {
	
	static int[] arr;
	
	static int find(int n) {
		if (arr[n] == n) {
			return n;
		}
		return arr[n] = find(arr[n]);
	}
	
	static void union(int a, int b) {
		arr[find(a)] = arr[find(b)];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		
		
		for (int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String temp = st2.nextToken();
			for (int j=0; j<N; j++) {
				int n = Integer.valueOf(temp.charAt(j)) - 96;
				if (n == -48) {
					n = 0;
				} else if (n <= 0) {
					n += 58;
				}
				map[i][j] = n;
			}
		}
		System.out.println(Arrays.deepToString(map));
		
		arr = new int[N];
		

	}

}
