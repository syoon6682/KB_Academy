package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;




public class BJ2644_촌수계산 {
	
	public static class Node{
		public int parent = 0;
		public ArrayList<Integer> child = new ArrayList<>();
	}
	
	static int[] visited;
	static ArrayList<Node> nodes;
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = 1;
		q.add(start);
		int cnt = 1;
		int qSize = q.size();
		while(!q.isEmpty()){
			for (int i=0; i<qSize; i++) {
				int test = q.poll();
				int p = nodes.get(test).parent;
				ArrayList<Integer> c = nodes.get(test).child;
				if (p != 0 && visited[p] == 0) {
					q.add(p);
					visited[p] = cnt;
				}
				for (int ch : c) {
					if (ch != 0 && visited[ch] == 0) {
						q.add(ch);
						visited[ch] = cnt;
					}
				}
			}
			cnt++;
			qSize = q.size();
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		visited = new int[n+1];
		
		nodes = new ArrayList<>();
		
		for (int i=0; i<=n; i++) {
			nodes.add(new Node());
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st2.nextToken());
		int end = Integer.parseInt(st2.nextToken());
		
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st3.nextToken());
		
		for(int i=0; i<m; i++) {
			StringTokenizer st4 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st4.nextToken());
			int e = Integer.parseInt(st4.nextToken());
			nodes.get(e).parent = s;
			nodes.get(s).child.add(e);
		}
		
		bfs(start);
		
		if (visited[end] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(visited[end]);
		}
	}

}
