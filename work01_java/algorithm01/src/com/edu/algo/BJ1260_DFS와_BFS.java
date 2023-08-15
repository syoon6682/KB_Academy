package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1260_DFS와_BFS {
	
	static int N;
	static int M;
	static int V;
	static int[][] map;
	static int[] bfsVisited;
	static int[] dfsVisited;
	static ArrayList<Integer> bfsAnswer;
	static ArrayList<Integer> dfsAnswer;
	
	static void dfs(int v) {
		dfsAnswer.add(v);
		dfsVisited[v] = 1;
		
		for (int i=1; i<N+1; i++) {
			if(map[v][i] == 1 && dfsVisited[i] == 0) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		bfsAnswer.add(v);
		bfsVisited[v] = 1;
		q.add(v);
		int qSize = q.size();
		
		while(qSize>0) {
			int test = q.poll();
			for(int i=1; i<N+1; i++) {
				if (map[test][i] == 1 && bfsVisited[i] == 0) {
					q.add(i);
					bfsAnswer.add(i);
					bfsVisited[i] = 1;
				}
			}
			qSize = q.size();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		bfsVisited = new int[N+1];
		dfsVisited = new int[N+1];
		bfsAnswer = new ArrayList<>();
		dfsAnswer = new ArrayList<>();
		
		dfs(V);
		bfs(V);
		
		for (int d : dfsAnswer) {
			System.out.print(d + " ");
		}
		System.out.println();
		for (int b : bfsAnswer) {
			System.out.print(b + " ");
		}
	}
}
