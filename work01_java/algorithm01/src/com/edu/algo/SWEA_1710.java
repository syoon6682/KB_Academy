package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Arrays;

public class SWEA_1710 {
	
	public static void findRoute(int[][] map) {
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int tc = Integer.parseInt(st.nextToken());
//			System.out.println(tc);
			int[][] map = new int[100][100];
			
			int point = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer temp = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					int road = Integer.parseInt(temp.nextToken());	
					map[i][j] = road;
					if (road==2) {
						point = j;
					}
				}
			}
			
//			System.out.println(point);
			int idx = 99;
			String direc = "U";
			
			while(true) {
				int left = point - 1;
				int right = point + 1;
				
				if (right < 100) {
					if((map[idx][right] == 1) & (direc == "U" | direc == "R")) {
					direc = "R";
					point += 1;
					continue;
					}
				}
				
				if (left >= 0) {
					if ((map[idx][left] == 1) & (direc == "U" | direc == "L")){
					direc = "L";
					point -= 1;
					continue;
					}
				}
				
				idx -= 1;
				direc = "U";
//				System.out.println(idx + " " + point);
				if (idx == 0) {
					break;
				}
					
			}
			
			System.out.println("#" + tc + " " + point);
		}
		
	}

}
