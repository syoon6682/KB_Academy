package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2667_단지번호붙이기 {
	
	static int N;
	static int[][] map;
	static ArrayList<Integer> memo;
	static int mark;
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		int[] start = {x, y};
		map[x][y] = 0;
		
		q.add(start);
		int qSize = q.size();
		int cnt = 1;
		while(qSize>0) {
			for(int i=0; i<qSize; i++) {
				int[] temp = q.poll();
				int tempX = temp[0];
				int tempY = temp[1];
				for(int j=0; j<4; j++) {
					int newX = tempX + dx[j];
					int newY = tempY + dy[j];
					if (newX >=0 && newX < N && newY >= 0 && newY < N && map[newX][newY] == 1) {
						int[] newPt = {newX, newY};
						map[newX][newY] = 0;
						q.add(newPt);
						cnt++;
					}
				}
			}
			qSize = q.size();
			
		}
		memo.add(cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		memo = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String temp = st2.nextToken();
			for (int j=0; j<N; j++) {
				map[i][j] = Character.getNumericValue(temp.charAt(j));
			}
		}
		
		mark = 2;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(memo);
		System.out.println(memo.size());
		for (int m:memo) {
			System.out.println(m);
		}

	}

}
