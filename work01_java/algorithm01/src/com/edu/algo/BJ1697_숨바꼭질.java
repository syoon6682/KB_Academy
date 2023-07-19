package com.edu.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1697_숨바꼭질 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[200000];
		arr[N] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		int qSize = q.size();
		int idx = 1;
		while(arr[M] == 0) {
			for(int i=0; i<qSize; i++) {
				int t = q.poll();
				
				if (t-1 >= 0 && arr[t-1] == 0) {
					arr[t-1] = idx;
					q.add(t-1);
				}
				if (t+1 <= 100000 && arr[t+1] == 0) {
					arr[t+1] = idx;
					q.add(t+1);
				}
				if (t*2 < 200000 && arr[t*2] == 0) {
					arr[t*2] = idx;
					q.add(t*2);
				}
			}
			idx++;
			qSize = q.size();
		}
		
		if (N==M) {
			System.out.println(0);
		} else {
			System.out.println(arr[M]);
		}
		

	}

}
