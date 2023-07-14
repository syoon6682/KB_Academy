/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
package com.edu.algo;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class SWEA_5215
{	
	static int N;
	static int L;
	static int[][] stuffs;
	static int sSum;
	static int cSum;
	static int global;
	
	static void dfs(int idx) {
		if (idx == N) {
			globalChecker(sSum);
		}
		
		for (int i=idx; i<N; i++) {
			sSum += stuffs[i][0];
			cSum += stuffs[i][1];
			
			if (cSum > L) {
				sSum -= stuffs[i][0];
				cSum -= stuffs[i][1];
				globalChecker(sSum);
			} else {
				dfs(i+1);
				sSum -= stuffs[i][0];
				cSum -= stuffs[i][1];
			}	
		}
	}
	
	static void globalChecker(int local) {
		if (local > global) {
			global = local;
		}
	}
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{	
			N = sc.nextInt();
			L = sc.nextInt();
			
			stuffs = new int[N][2];
			
			for(int i=0; i<N; i++) {
				int stuff = sc.nextInt();
				int calrorie = sc.nextInt();
				int[] temp = {stuff, calrorie};
				stuffs[i] = temp;
			}
			
			sSum=0;
			cSum=0;
			global=0;
			
			dfs(0);
			
			System.out.println("#" + test_case + " " + global);
			

		}
	}
}