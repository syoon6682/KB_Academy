package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1976_여행_가자 {
	
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
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st2.nextToken());
		
		arr = new int[N+1];
		for(int i=1; i<N+1; i++) {
			arr[i] = i;
		}
		
		for(int i=1; i<N+1; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				int temp = Integer.parseInt(st3.nextToken());
				if (temp == 1) {
					union(i, j);
				}
			}
		}
		
		boolean[] visited = new boolean[N+1];
		
		int std = 0;
		int local = 0;
		boolean answer = true;
		StringTokenizer st4 = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int test = Integer.parseInt(st4.nextToken());
			if (!visited[test]) {
				visited[test] = true;
				local = find(test);
				if (i == 0) {
					std = local;
				} else {
					if (std != local) {
						answer = false;
						break;
					}
				}
			}
		}
		if (answer) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		

	}

}
