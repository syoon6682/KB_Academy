package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1325_효율적인_해킹 {
	
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> map;
	static ArrayList<ArrayList<Integer>> map2;
	static int global;
	
	static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		
		q.add(n);
		set.add(n);
		int qSize = q.size();
		while(qSize>0) {
			for (int i=0; i<qSize; i++) {
				int temp = q.poll();
				for(int t : map2.get(temp)) {
					if (!set.contains(t)) {
						set.add(t);
						q.add(t);
					}
				}
			}
			qSize = q.size();
		}
		System.out.println(set.size());
		return set.size();
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new ArrayList<>();
		map2 = new ArrayList<>();
		for (int i=0; i<N+1; i++) {
			ArrayList<Integer> empty = new ArrayList<>();
			map.add(empty);
		}
		
		for (int i=0; i<N+1; i++) {
			ArrayList<Integer> empty2 = new ArrayList<>();
			map2.add(empty2);
		}
	
		for (int i=0; i<M; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(temp.nextToken());
			int y = Integer.parseInt(temp.nextToken());
			
			map.get(x).add(y);
			map2.get(y).add(x);
		}
		
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		global = 0;
		
		for (int i=1; i<N+1; i++) {
			if (map.get(i).size() == 0) {
				int test = bfs(i);
				if (test > global) {
					answer.clear();
					global = test;
					answer.add(i);
				} else if(test == global) {
					answer.add(i);
				}
			}
		}

		for(int a : answer) {
			System.out.print(a + " ");
		}
		
		
	}
}
