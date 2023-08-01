package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B_유기농배추 { // bfs(미로탐색)
	static int M, N, K, cnt;
	static int[][] arr;
	static boolean[][] v;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	
	public static class Pos {
		public int i, j;

		Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			v = new boolean[M][N];

			K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c1 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				arr[c1][c2] = 1;
			}

			for (int x = 0; x < M; x++) { // 배추가 심어져있는 곳 확인하는 for문
				for (int y = 0; y < N; y++) {
					if (arr[x][y] == 1 && !v[x][y]) { // 배추(1)이 있거나 방문안한 곳 있는지 확인
						bfs(new Pos(x, y)); // pos의 인자값을 넣어야함 여기서 객체를 주입함(근데 오류뜸)
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}

	static void bfs(Pos s) {
		Queue<Pos> q = new LinkedList<>();
		q.add(s);

		while (!q.isEmpty()) {
			Pos c = q.poll();
			if (c.i == M && c.j == N) {
				return;
			}
			for (int k = 0; k < 4; k++) {
				int nx = c.i + di[k];
				int ny = c.j + dj[k];
				if (nx >= 0 && ny >= 0 && nx < M && ny < N) { // 좌표내에서 돌아야하기 때문에
					if (v[nx][ny] == false && arr[nx][ny] == 1) { // 배추(1)부분과 방문하지 않은 다음 좌표
						q.add(new Pos(nx, ny));
						v[nx][ny] = true; // 여긴 왜 오류가 뜨는건가요
					}
				}
			}

		}
	}

	
}