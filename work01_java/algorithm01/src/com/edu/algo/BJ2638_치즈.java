package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2638_치즈 {

	static int N;
	static int M;
	static String[][] cheeze;
	
	static void twoMark() {
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheeze = new String[N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				cheeze[i][j] = temp.nextToken();
			}
		}
		
		// 외곽을 2로 마킹하고
		
		// 마킹되지 않은 부분을 둘러쌓인 부분으로 정의하고 3으로 마킹하고
		
		// while 문을 통해 녹일 부분 녹이고
		// 3 마킹 점검해서 밀폐 열렸으면 0으로 마킹처리 해버리고 반복
		
		// 1 마킹 체커 만들어서 아예 없으면 횟수 리턴
		
	}

}
