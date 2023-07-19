package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178_미로 {
	
	static int[][] map;
	static int N;
	static int M;
	
	static int bfs() {
		int cnt = 1;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		Queue<int[]> q = new LinkedList<>();
		map[0][0] = 2;
		int[] start = {0, 0};
		q.add(start);
		int qSize = q.size();
		
		while(map[N-1][M-1] == 1) {
			for(int i=0; i<qSize; i++) {
				int[] temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				map[x][y] = 2;
				for (int j=0; j<4; j++) {
					int newX = x+dx[j];
					int newY = y+dy[j];
					if (newX>=0 && newX<N && newY>=0 && newY<M && map[newX][newY] == 1) {
						int[] pt = {newX, newY};
						q.add(pt);
						map[newX][newY] = 2;
					}
				}
			}
			cnt++;
			qSize = q.size();
		}
		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			String s = temp.nextToken();
			for (int j=0; j<M; j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		
		System.out.println(bfs());
	}

}
