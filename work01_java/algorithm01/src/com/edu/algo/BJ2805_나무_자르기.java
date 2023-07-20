package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805_나무_자르기 {
	static int[] arr;
	static int N;
	static int M;
	
	static int binary(int s, int e) {
		if (s==e) {
			return e;
		}
		
		int mid = (s+e)/2;
		int local = 0;
		for (int a: arr) {
			if(a>mid) {
				local += (a-mid);
			}
		}

		if (local > M) {
			return binary(mid+1, e);
		} else {
			return binary(s, mid-1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		
		arr = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int answer = binary(0, 1000000000);
		System.out.println(answer);
		
	}

}
