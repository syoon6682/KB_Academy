package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17352_여러분의_다리가_되어드리겠습니다 {
	
	static int[] array;
	static int N;
	
	public static int find(int a) {
		if (array[a] == a) return a;
		else return array[a] = find(array[a]);
	}
	
	public static void union(int a, int b) {
		array[find(a)] = array[find(b)];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		array = new int[N+1];
		for (int i=0; i<N+1; i++) {
			array[i] = i;
		}
		
		for (int i=0; i<N-2; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			union(a, b);
		}
		
		System.out.println(Arrays.toString(array));
		
		for (int i=1; i<N+1; i++) {
			find(i);
		}
		
		int one = 0;
		int two = 0;
		for (int i=1; i<N+1; i++) {
			if (i==1) {
				one = array[i];
			} else {
				if (array[i] != one) {
					two = array[i];
					break;
				}
			}
			
		}
		
		System.out.println(one + " " + two);
	}
	

}
