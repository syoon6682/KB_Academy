package com.edu.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BJ2023_신기한_소수 {
	/*
	 * 문제 개요
	 * 한 자리수 소수는 2 3 5 7
	 * 두 자리 신기한 소수는 2, 3, 5, 7 + (1, 3, 7, 9) 가 후보군에 있을 거고
	 * 세 자리수 신기한 소수는 (두 자리수 신기한 소수) + (1, 3, 7, 9)가 후보군에 있음
	 * 이렇게 자리수별로 전 자리수를 반영하여 소수 판단해가는 문제
	 * 
	 * 이 문제는 코드로만 봐서는 난해할 수 있어서 스터디 때 얘기할 시간이 있다면 설명 자세하게 하겠습니다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new  HashMap<Integer, ArrayList<Integer>>();
		for (int i=1; i<N+1; i++) {
			map.put(i, new ArrayList<Integer>());
		}
		
		for (int i=1; i<N+1; i++) {
			dfs(i);
		}
		
		for(int i: map.get(N)) {
			System.out.println(i);
		}
		
	}

	static int N;
	static int[] odd = {1, 3, 7, 9};
	static HashMap<Integer, ArrayList<Integer>> map;
	
	// 1의 자리에서는 2, 3, 5, 7 추가
	static void dfs(int n) {
		if (n==1) {
			map.get(n).add(2);
			map.get(n).add(3);
			map.get(n).add(5);
			map.get(n).add(7);	
		}
		// 그 외의 자리에서는 전 자리수 신기한 소수에 1, 3, 7, 9 를 붙여보고 소수 판별 진행
		else {
			ArrayList<Integer> beforeList = map.get(n-1);
			for (int b: beforeList) {
				for (int o: odd) {
					StringBuilder temp = new StringBuilder();
					temp.append(b).append(o);
					int test = Integer.parseInt(temp.toString());
					if(cow(test)) {
						map.get(n).add(test);
					}
				}
			}
		}
	}
	
	// 소수 판별하는 함수
	static boolean cow(int test) {
		// 제곱근을 마지막 포인트로 잡고
		int end = (int) Math.sqrt((double) test);
		
		// 3부터 제곱근까지 나눈 나머지 중 하나라도 0이 나오면 소수 아님
		for (int i=3; i<end+1; i++) {
			if (test%i == 0) {
				return false;
			}
		}
		return true;
	}
}