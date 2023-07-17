package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.Stack;

public class BJ1931_회의실_배정 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] time = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(temp.nextToken());
			time[i][1] = Integer.parseInt(temp.nextToken());
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0] ;
			}
		});
		
		Stack<int[]> answer = new Stack<>();
		
		for(int[] t : time) {
			if (answer.size() == 0) {
				answer.add(t);
			} else {
				if (answer.peek()[1] <= t[0]) {
					answer.add(t);
				}
			}
		}
		System.out.println(answer.size());
	}
}
