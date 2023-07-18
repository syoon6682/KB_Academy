package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11054_가장_긴_바이토닉_부분_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int[] incline = new int[N];
		int[] decline = new int[N];
		
		for(int i=0; i< N; i++) {
			if (i==0) {
				incline[i] = 1;
				continue;
			}
			int local = 1;
			for(int j=0; j<i; j++) {
				if (arr[j]<arr[i] && incline[j]+1 > local) {
					local = incline[j]+1;
				}
			}
			incline[i] = local;
		}
		
		for(int i=N-1; i>=0; i--) {
			if (i==N-1) {
				decline[i] = 1;
				continue;
			}
			int local = 1;
			for(int j=N-1; j>i; j--) {
				if (arr[j]<arr[i] && decline[j]+1 > local) {
					local = decline[j]+1;
				}
			}
			decline[i] = local;
		}
		
		
		int global = 0;
		for(int i=0; i<N; i++) {
			int local = incline[i] + decline[i];
			if(global < local) {
				global = local;
			}
		}
		System.out.println(global-1);
		
	}

}
