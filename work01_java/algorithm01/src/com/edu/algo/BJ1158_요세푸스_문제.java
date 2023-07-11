package com.edu.algo;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BJ1158_요세푸스_문제 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> answer = new LinkedList<>();
		
		
		for(int i=1; i<N+1; i++) {
			q.add(i);
		}
		
		int idx = 0;
		while(true) {
			if (idx == K-1) {
				answer.add(q.poll());
				idx = 0;
				if (q.size() == 0) {
					break;
				}
			} else {
				q.add(q.poll());
				idx++;
			}
		}
		
		System.out.print("<");
		for(int i=0; i<N; i++) {
			if(i == N-1) {
				System.out.print(answer.poll());
			} else {
				System.out.print(answer.poll() + ", ");	
			}
			
		}
		System.out.print(">");

	}

}
