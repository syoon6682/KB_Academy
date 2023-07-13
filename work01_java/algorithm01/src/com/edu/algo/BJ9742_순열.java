package com.edu.algo;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;

public class BJ9742_순열 {
	
	static int cnt;
	static char[] arr;
	static int num;
	static Stack<Character> darr;
	static Stack<Character> answer;
	
	public static void dfs() {
		 if (darr.size() == arr.length) {
			 cnt++;
			 if (cnt==num) {
				 answer = (Stack<Character>) darr.clone();
			 }
		 }
		 else {
			 for(char a:arr) {
				 if (!darr.contains(a)) {
					 darr.add(a);
					 dfs();
					 darr.pop();
				 }
			 }
		 }
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String word = sc.next();
			num = sc.nextInt();
			arr = word.toCharArray();
			
			int fac = 1;
			for (int i=1; i<arr.length+1;i++) {
				fac *= i;
			}
			
			if(fac < num) {
				System.out.println(word + " " + num + " = No permutation");
			} else {
				darr = new Stack<>();
				answer = new Stack<>();
				cnt = 0;
				dfs();
				
				
				System.out.print(word + " " + num + " = ");
				for(char a:answer) {
					System.out.print(a);
				}
				System.out.println();
				
			}
			
		}
	}
}


