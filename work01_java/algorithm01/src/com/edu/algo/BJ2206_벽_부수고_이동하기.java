package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N=M=1 case 생각
 */



public class BJ2206_벽_부수고_이동하기 {
	
	static int N;
	static int M;
	static int min = 1000001;
	static HashSet<XY> visited;
	static char[][] map;
	static int[] end;
	
	public static class XY{
		int x;
		int y;
		
		public void setter(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	
	public static void bfs(Queue<XY> test) {
		int cnt = 0;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		while(test.size()>0) {
			cnt ++;
			System.out.println(test.size());
			int testLen = test.size();
			for(int i=0; i < testLen; i++) {
				XY temp = test.poll();
				System.out.println(test.size());
				int x = temp.x;
				int y = temp.y;
				for(int j=0; j<4; j++) {
					int new_x = x+dx[j];
					int new_y = y+dy[j];
					if(new_x >= 0 && new_x <N && new_y >= 0 && new_y<M) {
						XY obj = new XY();
						obj.setter(new_x,  new_y);
						if(map[new_x][new_y] == '0' && !visited.contains(obj) ) {
							test.add(obj);
							visited.add(obj);
						}
					}
				}
			}
			System.out.println(visited.size());
//			System.out.println(visited.size());
			
			if (visited.contains(end)) {
				if (min > cnt) {
					min = cnt;
				}
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] end = {N-1, M-1};
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer list = new StringTokenizer(br.readLine());
			char[] temp = list.nextToken().toCharArray();	
			map[i] = temp;
		}
		Queue<XY> test = new LinkedList<XY>();
		visited = new HashSet<XY>(); 
		
		
		// 벽 부수기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (map[i][j]=='1') {
					map[i][j] = '0';
					test.clear();
					visited.clear();
					XY start = new XY();
					start.setter(i, j);
					visited.add(start);
					test.add(start);

					bfs(test);
					
					map[i][j] = '1';
				}
			}
		}
		
		System.out.println(min);
		
	}

}
