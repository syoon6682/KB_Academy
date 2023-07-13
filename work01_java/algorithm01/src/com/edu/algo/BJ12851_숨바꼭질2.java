package com.edu.algo;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;


public class BJ12851_숨바꼭질2 {
	
	static Queue<Integer> q = new LinkedList<>();
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int[] index = new int[100001];
	static int N;
	static int K;
	static int cnt = 0;
	static int cntMethod = 0;
	
	static public void dp() {
		int temp = q.poll();
		int temp1 = temp + 1;
		int temp2 = temp - 1;
		int temp3 = temp * 2;
		
		if (temp1 <= 100000 && index[temp1] == 0) {
			putKey(temp, temp1);
		}		
		if (temp2 >= 0 && index[temp2] == 0) {
			putKey(temp, temp2);
		}
		if (temp != 0 && temp3 <= 100000 && index[temp3] == 0) {		
			putKey(temp, temp3);
		}
	}
	
	public static void putKey(int temp, int newT) {
		q.add(newT);
		if(map.containsKey(newT)) {
			map.put(newT, map.get(newT)+index[temp]);
		} else {
			map.put(newT, index[temp]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		q.add(N);
		index[N] = 1;
		
		while(index[K] == 0) {
			map.clear();
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				dp();
			}
			
			for (int k : map.keySet()) {
				index[k] = map.get(k);
			}
			
			cnt++;
		}
		System.out.println(cnt);
		System.out.println(index[K]);
		
	}
}
