package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ11660_구간_합_구하기_5 {

	public static void main(String[] args) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] numList = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j = 1; j < N+1; j++) {
			int t = Integer.parseInt(temp.nextToken());
			numList[i][j] = numList[i][j-1] + t;
			}
		}
//		System.out.println(Arrays.deepToString(numList));
		
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				numList[j][i] += numList[j-1][i];
			}
		}

		
		System.out.println(Arrays.deepToString(numList));
		
		for(int i = 0; i < M; i++) {
			StringTokenizer xy = new StringTokenizer(br.readLine());
			
			int xs = Integer.parseInt(xy.nextToken());
			int ys = Integer.parseInt(xy.nextToken());
			int xe = Integer.parseInt(xy.nextToken());
			int ye = Integer.parseInt(xy.nextToken());
			int answer = numList[xe][ye] - numList[xe][ys-1] - numList[xs-1][ye] + numList[xs-1][ys-1];
			
			System.out.println(answer);
		}
	}

}
