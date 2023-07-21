package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1197_최소_스패닝_트리 {
	
	static int[] set;
	
	public static int justFind(int f) {
		if(set[f] == f) {
			return f;
		} else {
			return find(set[f]);
		}
	}
	
	public static int find(int f) {
		if(set[f] == f) {
			return f;
		} else {
			return set[f] = find(set[f]);
		}
	}
	
	public static void union(int a, int b) {
		set[find(a)] = set[find(b)];
	}
	
	public static class Node {
		public int start;
		public int end;
		public int cost;
		
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		set = new int[V+1];
		for (int i=1; i<V+1; i++) {
			set[i] = i;
		}
		
		for (int i=0; i<E; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(temp.nextToken());
			int e = Integer.parseInt(temp.nextToken());
			int c = Integer.parseInt(temp.nextToken());			
			q.add(new Node(s, e, c));
		}
		
		int cnt = 0;
		int answer = 0;
		while (cnt < V-1) {
			Node test = q.poll();
			if (justFind(test.start) != justFind(test.end)) {
				union(test.start, test.end);
				answer += test.cost;
				cnt++;
			}
		}
		
		System.out.println(answer);

	}

}
