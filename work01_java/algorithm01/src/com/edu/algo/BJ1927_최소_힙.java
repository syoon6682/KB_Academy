package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1927_최소_힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int N = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st2.nextToken());
			
			
			
			if (n==0) {
				if(q.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(q.poll());
				}
			} else {
				q.add(n);
			}
		}
	}

}
