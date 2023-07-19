package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ27172_수_나누기_게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		HashMap<Integer, Integer> score = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		

		for (int i=0; i<N; i++) {
			int temp = Integer.parseInt(st2.nextToken());
			score.put(temp, 0);
			set.add(temp);
			arr[i] = temp;
		}
		
		int[] sortedArr = arr.clone();
		Arrays.sort(sortedArr);
		int maxValue = sortedArr[N-1];

		for (int a: sortedArr) {
			int j = 2;
			int test = a*j;
			while (test <= maxValue) {
				if (set.contains(test)) {
					score.put(a, score.get(a)+1);
					score.put(test, score.get(test)-1);
				}
				test = a*(++j);
			}
		}
		
		for(int a: arr) {
			System.out.print(score.get(a) + " ");
		}
	}
	
}
