package com.edu.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Bj17608_막대기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack();
		
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int test = Integer.parseInt(temp.nextToken());
			
			while(true) {
				if (stack.empty()) {
					stack.add(test);
					break;
				} else if (stack.peek() < test) {
					stack.pop();
				} else if (stack.peek() > test) {
					stack.add(test);
					break;
				} else {
					break;
				}
			}
		}	
		System.out.println(stack.size());
	}
}
 