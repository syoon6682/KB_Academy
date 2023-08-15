package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11123_양_한마리_양_두마리 {

	public static class Pos {
		public int h;
		public int w;

		public Pos(int h, int w) {
			this.h = h;
			this.w = w;
		}
	}

	static int[][] map;
	static int cnt;
	static int H;
	static int W;

	public static void bfs(int h, int w) {
		Queue<Pos> q = new LinkedList<>();
		Pos start = new Pos(h, w);
		map[h][w] = 0;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		q.add(start);
		while (!q.isEmpty()) {
			Pos test = q.poll();
			for (int i=0; i<4; i++) {
				int newH = test.h + dx[i];
				int newW = test.w + dy[i];
				
				if (newH >=0 && newW>=0 && newH < H && newW < W && map[newH][newW] == 1) {
					q.add(new Pos(newH, newW));
					map[newH][newW] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st2.nextToken());
			W = Integer.parseInt(st2.nextToken());

			map = new int[H][W];

			for (int h = 0; h < H; h++) {
				// map 입력 단계
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				String temp = st3.nextToken();
				for (int w = 0; w < W; w++) {
					char test = temp.charAt(w);
					if (test == '#') {
						map[h][w] = 1;
					}
				}
			}

			cnt = 0;
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					if (map[h][w] == 1) {
						bfs(h, w);
						cnt++;
					}
				}
			}
			System.out.println(cnt);

		}

	}

}
