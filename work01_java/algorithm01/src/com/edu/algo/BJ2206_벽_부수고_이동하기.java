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
	static char[][] map;
	static int[] end;
	
	static char[][] mapClone(){
		char[][] answer = new char[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				answer[i][j] = map[i][j];
			}
		}
		return answer;
	}
	
	static int bfs(char[][] clone) {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		clone[0][0] = 2;
		int[] start = {0, 0};
		q.add(start);
		
		int qSize = q.size();
		while(qSize>0) {
			for(int i=0; i<qSize; i++) {
				int[] temp = q.poll();
				
				for(int j=0; j<4; j++) {
					int newX = temp[0] + dx[j];
					int newY = temp[1] + dy[j];
					if (newX>=0 && newX<N && newY>=0 && newY<M && clone[newX][newY] == '0') {
						int[] pt = {newX, newY};
						clone[newX][newY] = '2';
						q.add(pt);
					}
				}
			}
			
			qSize = q.size();
			cnt++;
			if(clone[N-1][M-1] == '2') {
				return cnt+1;
			}
			
		}
		
		return 0;
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

		
		// 벽 부수기
		int idx = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (map[i][j]=='1') {
					idx++;
					char[][] clone = mapClone();
					clone[i][j] = '0';
					int local = bfs(clone);
					if (local != 0 && min > local) {
						min = local;
					}
					
				}
			}
		}
	
		if(min ==1000001) {
			System.out.println(-1);
		} else {
			System.out.println(min);	
		}
		
	}

}
