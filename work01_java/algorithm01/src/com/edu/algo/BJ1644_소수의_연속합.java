package com.edu.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BJ1644_소수의_연속합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if (N == 1) {
			System.out.println(0);
			return;
		}
		
		int[] arr = new int[N+1];
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2; i<=N; i++) {
			if (arr[i] == 0) {
				int test = i * 2;
				while (N >= test) {
					if (arr[test] == 0) {
						arr[test] = 1;
					}
					test += i;
				}
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		int idx = 0;
		for(int a: arr) {
			if (a==0) {
				q.add(idx);
			}
			idx++;
		}
		
		int[] subset = new int[q.size()+1];
		
		int qSize = q.size();
		for (int i=1; i<qSize+1; i++) {
			int temp = q.poll();
				subset[i] = subset[i-1] + temp;
		}
		
		int cnt = 0;
		int s = 0;
		int e = 1;
		while (s < subset.length && e < subset.length) {
			int sum = subset[e] - subset[s];
			if (sum > N) {
				s++;
			} else if (sum < N) {
				e++;
			} else {
				cnt++;
				e++;
			}
		}
		System.out.println(cnt);
		
	}

}
