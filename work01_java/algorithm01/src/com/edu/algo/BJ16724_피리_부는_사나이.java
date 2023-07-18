package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16724_피리_부는_사나이 {
	
	static int N;
	static int M;
	static char[][] map;
	
	static void forward(int x, int y) {
		int newX = x;
		int newY = y;
		
		while(true) {			
			if(map[newX][newY] == 'C') {
				backward(newX, newY);
				break;
			} else if (map[newX][newY] == 'U') {
				map[newX][newY] = 'C';
				newX -= 1;
				backward(newX, newY);
			} else if (map[newX][newY] == 'D') {
				map[newX][newY] = 'C';
				newX += 1;
				backward(newX, newY);
			} else if (map[newX][newY] == 'R') {
				map[newX][newY] = 'C';
				newY += 1;
				backward(newX, newY);
			} else if (map[newX][newY] == 'L') {
				map[newX][newY] = 'C';
				newY -= 1;
				backward(newX, newY);
			}
		}
	}
	
	static void backward(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		int[] start = {x, y};
		q.add(start);
		
		int qSize = q.size();
		while(qSize>0) {
			for(int i=0; i<qSize; i++) {
				int[] temp = q.poll();
				int newX = temp[0]+1;
				int newY = temp[1];
				if (newX>=0 && newX<N && newY>=0 && newY<M && map[newX][newY] == 'U') {
					int[] pt = {newX, newY};
					q.add(pt);
				}
				
				newX = temp[0]-1;
				newY = temp[1];
				if (newX>=0 && newX<N && newY>=0 && newY<M && map[newX][newY] == 'D') {
					int[] pt = {newX, newY};
					q.add(pt);
				}
				
				newX = temp[0];
				newY = temp[1]+1;
				if (newX>=0 && newX<N && newY>=0 && newY<M && map[newX][newY] == 'L') {
					int[] pt = {newX, newY};
					q.add(pt);
				}
				
				newX = temp[0];
				newY = temp[1]-1;
				if (newX>=0 && newX<N && newY>=0 && newY<M && map[newX][newY] == 'R') {
					int[] pt = {newX, newY};
					q.add(pt);
				}
				
				map[temp[0]][temp[1]] = 'C';
			}
			qSize = q.size();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			map[i] = temp.nextToken().toCharArray();
		}
	
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 'C') {
					backward(i, j);
					forward(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

}
