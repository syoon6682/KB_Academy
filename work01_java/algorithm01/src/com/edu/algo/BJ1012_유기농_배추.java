package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1012_유기농_배추 {

	/*
	 * 문제 개요
	 * BFS를 활용하여 영역을 카운트하는 문제로
	 * 특이한 건 가로, 세로가 바뀌었다.
	 * Point라는 class를 만들어서 좌표를 저장해보았습니다.
	 */
	public static void main(String[] args) throws IOException {
		// 입력 레벨
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st1.nextToken());
		
		// Map에 정보를 저장하는데 가로 세로가 바뀌어 있는 점을 유의
		for (int k=0; k<T; k++) {
			cnt = 0;
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st2.nextToken());
			N = Integer.parseInt(st2.nextToken());
			K = Integer.parseInt(st2.nextToken());
			map = new int[N][M];
			for (int i=0; i<K; i++) {
			
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st3.nextToken());
				int n = Integer.parseInt(st3.nextToken());
				map[n][m] = 1;
			}
			
			// 2중 for문을 통해 2차원 배열 순회를 하는데
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					// 만약 해당 위치가 1이라면
					if (map[i][j] == 1) {
						// 수를 카운트하고 bfs 실시
						cnt++;
						bfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	// 변수의 static 화
	static int M;
	static int N;
	static int K;
	static int cnt;
	static int[][] map;
	
	// 좌표를 저장해줄 Point class
	public static class Point {
		public int x;
		public int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// BFS 함수
	// 4방향 검색과 Map 변수를 Visited 함수로 활용하여 BFS 함수 구현
	public static void bfs(int x, int y) {
		Queue<Point> q=  new LinkedList<>();
		q.add(new Point(x, y));
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		int qSize = q.size();
		map[x][y] = 0;
		
		while(qSize > 0) {
			for(int i=0; i<qSize; i++) {
				Point temp = q.poll();
				x = temp.x;
				y = temp.y;
				for (int j=0; j<4; j++) {
					int newX = x + dx[j];
					int newY = y + dy[j];
					if (newX >= 0 && newX < N && newY >= 0 && newY <M && map[newX][newY] == 1) {
						map[newX][newY] = 0;
						q.add(new Point(newX, newY));
					}
				}
			}
			qSize = q.size();
		}
	}
}
