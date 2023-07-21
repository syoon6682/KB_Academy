package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14940_쉬운_최단거리 {
	
	static int n;
	static int m;
	static int[][] map;
	static int[][] answer;
	static Queue<int[]> q;
	
	static void bfs() {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		int idx = 1;
		int qSize = q.size();
		while (qSize > 0) {
			for(int i=0; i<qSize; i++) {
				int[] temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				for (int j=0; j<4; j++) {
					int newX = x + dx[j];
					int newY = y + dy[j];
					if (newX >= 0 && newX < n && newY >= 0 && newY < m && map[newX][newY] == 1) {
						int[] point = {newX, newY};
						q.add(point);
						map[newX][newY] = 0;
						answer[newX][newY] = idx;
					}
				}
			}
			qSize = q.size();
			idx++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		answer = new int[n][m];
		q = new LinkedList<>();
		
		for (int i=0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if (map[i][j] == 2) {
					int[] start = {i, j};
					q.add(start);
				}
			}
		}
		
		bfs();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if (map[i][j] == 1) {
					answer[i][j] = -1;
				}
			}
		}
		
		System.out.println(Arrays.deepToString(answer));
		
	}
}
