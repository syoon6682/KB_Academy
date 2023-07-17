package com.edu.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1233 {
	static int N, ans;
	static char[] tree;
	public static void main(String[] args) throws NumberFormatException, IOException{
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기

		//	TC는 10개로 고정
		for (int tc=1; tc<=10; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N+1];

			//	완전이진트리, 두 번째 입력의 첫 한글자만 입력(숫자 제일 앞글자 또는 연산자)
			for (int i=1; i<=N; i++) {
				tree[i] = br.readLine().split(" ")[1].charAt(0);
			}

			// 입력 정확히 받았는지 확인
//			System.out.println(tree);
			// 완전이진트리 가장 끝 노드부터 반대방향으로 체크 ~ 2까지
			ans = 1;
			for (int i=N; i>1; i-=2) {
				//	정상적인 계산식일 경우 연산자 자리를 숫자로 저장
				if (!isOP(tree[i]) && !isOP(tree[i-1]) && isOP(tree[i/2])) {
					tree[i/2] = '1';
				}else {	//	연산이 불가능한 경우
					ans = 0;
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static boolean isOP(char ch) {
		if (ch=='+' || ch=='-' || ch=='*' || ch=='/') {
			return true;
		}
		return false;
	}
	
}
