package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493_탑 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> tower = new Stack();
		Stack<Integer> idx = new Stack<>();
		Stack<Integer> answer = new Stack<>();
		
		int N = Integer.parseInt(st.nextToken());
		StringTokenizer token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			
			int temp = Integer.parseInt(token.nextToken());
			
			while(true){
				if (tower.isEmpty()) {
					answer.push(0);
					tower.add(temp);
					idx.add(i);
					break;
				}
				
				if (tower.peek() < temp) {
					tower.pop();
					idx.pop();
					continue;
				} else if (tower.peek() > temp) {
					answer.push(idx.peek()+1);
					tower.push(temp);
					idx.push(i);
					break;
				}
			}
		}
		
		for(int a: answer) {
			System.out.print(a + " ");
		}
	}

}
