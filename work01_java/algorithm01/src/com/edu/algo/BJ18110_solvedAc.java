package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ18110_solvedAc {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(temp.nextToken());
		}
		
		Arrays.sort(arr);
		int except = (int) Math.round(N*0.15);
		int s = except;
		int e = N-except;
		
		int sum = 0;
		for (int i=s; i<e; i++) {
			sum += arr[i];
		}
		System.out.println(Math.round((double) sum / (double) (N - 2*except)));

	}

}
