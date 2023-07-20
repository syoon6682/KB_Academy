package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class BJ1916_최소비용_구하기 {
	
	public static class Node {
		int v;
		int cost;
		
		public Node(int v, int cost){
			this.v = v;
			this.cost = cost;
		}
		
	}
	
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st2.nextToken());
		
		ArrayList<Node>[] graph = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}

		
//		System.out.println(Arrays.deepToString(graph));
		
		for (int i=0; i<M; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(temp.nextToken());
			int y = Integer.parseInt(temp.nextToken());
			int z = Integer.parseInt(temp.nextToken());
			graph[x].add(new Node(y,z));
//			graph[y].add(new Node(x,z));
		}
		
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st3.nextToken());
		int end = Integer.parseInt(st3.nextToken());
		
		// 초기 세팅
		// 시작 끝점 0과 true 세팅하고 첫 노드들 저장해두기
		visited[start] = true;
		Node startNode = new Node(start, 0);
		dist[start] = 0;
		
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		q.add(startNode);
		
		
		while (!visited[end]){
			Node now = q.poll();
			
			visited[now.v] = true;
			
			for (Node next : graph[now.v]) {
				if(!visited[next.v] && next.cost + now.cost < dist[next.v]) {
					dist[next.v] = next.cost + now.cost;
					q.add(new Node(next.v, dist[next.v]));
				}
			}
		}
		
		System.out.println(dist[end]);
		// 다익스트라는 노드 선택
		
		// 노드 탐색 및 갱신
		
		// 다음 노드를 priori
		
		
	}
		
}


