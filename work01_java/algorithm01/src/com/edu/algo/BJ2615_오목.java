package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2615_오목 {
	
	static int[][] arr;
	static int win;
	
	static int[] search(int n) {
		int[] dx = {1, 0, 1, 1};
		int[] dy = {0, 1, 1, -1};
		
		int[] t= new int[2];
		
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				
				if (arr[i][j]==n){

					int cnt = 1;

					for(int k=0; k<4; k++) {
						int biggerX = i + dx[k];
						int biggerY = j + dy[k];
						int smallerX = i - dx[k];
						int smallerY = j - dy[k];
						
						boolean flag = false;
						
						while (true) {
							flag = true;
							
							if (biggerX >= 0 && biggerX < 19 && biggerY >= 0 && biggerY < 19 && arr[biggerX][biggerY]==n) {
								cnt++;
								biggerX += dx[k];
								biggerY += dy[k];
								flag = false;
							}
							
							if (smallerX >= 0 && smallerX < 19 && smallerY >= 0 && smallerY < 19 && arr[smallerX][smallerY]==n) {
								cnt++;
								smallerX -= dx[k];
								smallerY -= dy[k];
								flag = false;
							}

							if(flag) {
								break;
							}		
						}
						if (cnt == 5) {
							win = n;
							int[] answer = {i+1, j+1};
							return answer;	
						}
					}
					
				}
			}
		}
		return t;
	}
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[19][19];
		for(int i=0; i<19; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());	
			for(int j=0; j<19; j++) {
				arr[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		
		win = 0;
		
		int[] oneAnswer = search(1);
		if (win==1) {
			System.out.println(win);
			System.out.println(oneAnswer[0] + " " + oneAnswer[1]);
		} else {
			int[] twoAnswer = search(2);
			if(win==2) {
				System.out.println(win);
				System.out.println(twoAnswer[0] + " " + twoAnswer[1]);
			} else {
				System.out.println(win);
			}
		}
	}
}
