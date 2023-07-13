package com.edu.algo;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class BJ1758_암호_만들기 {
	
	static int L;
	static int C;
	static LinkedList<String> answer = new LinkedList<>();
	static String[] arr;
	static Stack<String> aeiou = new Stack<>();
	static Stack<String> bcd = new Stack<>();
	static Deque<String> test = new ArrayDeque<>();

	public static void dfs(int c, int n) {
		if (c == L) {
			if(checker()){
				String[] testCopy = new String[L];
				Iterator<String> it = test.iterator();
				int idx = 0;
				while(it.hasNext()) {
					testCopy[idx++] = it.next();
				}
				Arrays.sort(testCopy);
				
				String item = "";
				for(String t : testCopy) {
					item += t;
				}
				answer.add(item);
			}
		} else {
			if (n == C) {
				return;
			}
			
			for(int i=n; i<C; i++) {
				if (!test.contains(arr[i])) {
					test.add(arr[i]);
					dfs(c+1, i+1);
					test.pollLast();
				}
			}
		}
	}
	
	public static boolean checker() {
		int aCnt = 0;
		int bCnt = 0;
		for (String s: test) {
			if (aeiou.contains(s)) {
				aCnt += 1;
			} else {
				bCnt += 1;
			}
		}
		
		if (aCnt>=1 && bCnt>=2) return true;
		else return false;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		arr = new String[C];
		
		for(int i=0; i<C; i++) {
			String temp = sc.next();
			arr[i] = temp;
			if (temp.equals("a") || temp.equals("e") || temp.equals("i") || temp.equals("o") || temp.equals("u")) {
				aeiou.add(temp);
			} else {
				bcd.add(temp);
			}
		}

		dfs(0, 0);
		
		Collections.sort(answer);
		for (String a:answer) {
			System.out.println(a);
		}
	}
}
