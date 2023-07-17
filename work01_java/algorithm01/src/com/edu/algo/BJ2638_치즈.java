package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2638_치즈 {

	static int N;
	static int M;
	static int[][] cheeze;
	static int cnt;
	static HashSet<int[]> three = new HashSet<>();
	
	static boolean oneCheck() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (cheeze[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	 
	static void mark(int from, int to, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		int[] init = {x, y};
		q.add(init);
		int qSize = q.size();
		while(qSize > 0) {
			qSize = q.size();
			for(int i=0; i<qSize; i++) {
				int[] temp = q.poll();
				for(int j=0; j<4; j++) {
					int newX = temp[0]+dx[j];
					int newY = temp[1]+dy[j];
					if(newX >= 0 && newX<N && newY >= 0 && newY < M && cheeze[newX][newY] == from) {
						cheeze[newX][newY] = to;
						int[] t = {newX, newY};
						q.add(t);
						if(to == 3) {
							three.add(t);
						}
						if(from==3 && to==2) {
							three.remove(temp);
						}
					}
					
				}
			}
		}
	}
	

	static void threeCheck() {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(int[] t : three) {
			for (int k=0; k<4; k++) {
				int newX = t[0] + dx[k];
				int newY = t[1] + dy[k];
				if(newX >= 0 && newX<N && newY >= 0 && newY < M && cheeze[newX][newY] == 2) {
					mark(3, 2, t[0], t[1]);
					break;
				}
			}
		}		
	}

	
	static void cheeseMelt() {
		Queue<int[]> answer = new LinkedList<>();
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(cheeze[i][j] == 1) {
					int c = 0;
					for (int k=0; k<4; k++) {
						int newX = i + dx[k];
						int newY = j + dy[k];
						if(newX >= 0 && newX<N && newY >= 0 && newY < M && cheeze[newX][newY] == 2) {
							c++;
						}
					}
					if (c>=2) {
						int[] t = {i, j};
						answer.add(t);
					}
				}
			}
		}
		while(answer.size() > 0) {
			int[] temp = answer.poll();
			cheeze[temp[0]][temp[1]] = 2;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheeze = new int[N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				cheeze[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		
		
		if (oneCheck()) {
			System.out.println(cnt);
		} else {
			
			mark(0, 2, 0, 0);
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(cheeze[i][j] == 0) {
						mark(0, 3, i, j);
					}
				}
			}
//			System.out.println(three);
			while(true) {
				cnt ++;
				cheeseMelt();
				threeCheck();
				System.out.println(three);
				if(oneCheck()) {
					break;
				}
			}
			System.out.println(cnt);
		}
		
	}

}
