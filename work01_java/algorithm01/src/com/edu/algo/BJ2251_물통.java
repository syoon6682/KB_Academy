package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2251_물통 {
	
	static ArrayList<Integer> answer = new ArrayList<>();
	
	
	// a가 비어있어야 하는 조건이므로 a 물통으로 덜어서 b 물통으로 옮기는 방식
	public static void dfs(int a, int b, int c) {
		if (b <= 0 || c <= 0) {
			return;
		}
		else {
			if(!answer.contains(c)) {
				answer.add(c);
			}
			int newB = b-a;
			int newC = c-a;
			dfs(a, newB, newC);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
			
		dfs(a, b, c);
		
		System.out.println(answer);
	}
	
	

}
