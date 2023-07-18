package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2467_용액 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] dp = new int[N];
		dp[0] = 0;
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
			
		}
		
		int s = 0;

		int global = 2000000000;
		int local = 0;
		
		for(int i=1; i<N; i++) {
			if (i==1) {
				s=0;
				arr[i] = 0;
				local = arr[s] + arr[i];
			} else {
				while(true) {
					if (s+1==i) {
						break;
					} else if(Math.abs(local) > Math.abs(arr[s] + arr[i])) {
						s++;
						local = arr[s] + arr[i];
					} else {
						break;
					}
				}
				dp[i] = s;
				System.out.println(local);
			}
		}
		
		System.out.println(Arrays.toString(dp));
	}

}
