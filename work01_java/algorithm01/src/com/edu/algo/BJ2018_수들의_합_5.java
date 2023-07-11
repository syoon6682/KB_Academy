package com.edu.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ2018_수들의_합_5 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int s = 0;
		int e = 1;
		int result = 0;
		int cnt = 0;
		while (e <= N) {
			if (result > N) {
				result -= s++;
			} else if (result < N) {
				result += e++;
			} else {
				cnt++;
				result += e++;
			}
		}
		
		System.out.println(cnt+1);
	}

}
