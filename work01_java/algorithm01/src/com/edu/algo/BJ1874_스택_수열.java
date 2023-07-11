package com.edu.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BJ1874_스택_수열 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int idx = 1;
		Stack<Integer> stack = new Stack<>();
		Queue<String> q = new LinkedList();
		boolean flag = true;
		
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(temp.nextToken());
			
			if (t >= idx) {
				while (t >= idx) {
					stack.add(idx);
					idx++;
					q.add("+");
				}
			}
			
			if (stack.peek() == t) {
				stack.pop();
				q.add("-");
			} else {
				flag = false;
				break;
			}
		}

		if(flag) {
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				System.out.println(q.poll());
			}
		} else {
			System.out.println("NO");
		}
	}

}
