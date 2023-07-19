package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1966_프린터_큐 {
	
	static Queue<Integer> q;
	static int N;
	static int M;
	static int[] ipt;
	
	static int que() {
		int cnt = 0;
		while(true) {
			cnt++;
			int globalMax = 0;
			for(int im : q) {
				if (ipt[im] > globalMax) {
					globalMax = ipt[im];
				}
			}
			int temp = 0;
			while(true) {
				temp = q.poll();
				if (ipt[temp] == globalMax) {
					if(temp == M) {
						return cnt;
					}

					break;
				}
				q.add(temp);
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer testCase = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(testCase.nextToken());
		
		for (int t=0; t<T; t++) {
			q = new LinkedList<>();
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st1.nextToken());
			M = Integer.parseInt(st1.nextToken());
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			ipt = new int[N];
			for (int i=0; i<N; i++) {
				ipt[i] = Integer.parseInt(st2.nextToken());
				q.add(i);
			}
			
			
			
			System.out.println(que());
			
		}
		
	}
}
