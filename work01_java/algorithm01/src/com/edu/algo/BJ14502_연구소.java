package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class BJ14502_연구소 {

	static int global;
	static int N;
	static int M;
	static Vector<int[]> zero = new Vector<>();
	static Vector<int[]> two = new Vector<>();
	static int zeroSize;
	static String[][] map;
	static Stack<int[]> wall = new Stack<>();
	
	static void setWall(int n, int c, int idx) {
		if (c == n) {
			String[][] mapCopy = map.clone();
			for(int[] w: wall) {
				System.out.println(Arrays.toString(w));
			}
			System.out.println();
			
			for(int i=0; i<3; i++) {
				int x = wall.get(i)[0];
				int y = wall.get(i)[1];
				mapCopy[x][y] = "1";
//			System.out.println(Arrays.deepToString(mapCopy));
			virus(mapCopy);				
			}
		} else if (idx == zeroSize) {
			return;
		} else {
			for (int i=idx; i<zeroSize; i++) {
				wall.add(zero.get(i));
				setWall(n, c+1, i+1);
				wall.pop();
			}
		}
	}
	
	static void virus(String[][] copy) {
		Queue<int[]> q = new LinkedList<>();
		for(int[] t : two) {
			q.add(t);
		}
		
		int qSize = q.size();
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		while(qSize>0) {
			for(int i=0; i<qSize; i++) {
				int[] test = q.poll();
				int x= test[0];
				int y = test[1];
				copy[x][y] = "2";
				for(int j=0; j<4; j++) {
					int newX=x+dx[j];
					int newY=y+dy[j];
					if(newX>=0 && newX<N && newY>=0 && newY<M && copy[newX][newY]=="0") {
						int[]temp = {newX,newY};
						q.add(temp);
					}
				}	
			}
			qSize = q.size();
		}
		
		// global 비교
		int local=0;
		for(int i=0; i<N;i++) {
			for(int j=0; j<M; j++) {
				if(copy[i][j] == "0") {
					local += 1;
				}
			}
		}

		if(local>global) {
			global = local;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		global = 0;
		map = new String[N][M];
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				String token = temp.nextToken();
				map[i][j] = token;
				if (token.equals("0")) {
					int[] zeroP = {i, j};
					zero.add(zeroP);
				} else if (token.equals("2")) {
					int[] twoP = {i, j};
					two.add(twoP);
				}
			}
		}
		
		zeroSize = zero.size();
		
		
		// 벽 설치 위치 선정
		setWall(3, 0, 0);
		
		System.out.println(global);
	}

}
