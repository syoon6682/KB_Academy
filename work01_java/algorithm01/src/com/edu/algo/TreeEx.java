package com.edu.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeEx {
	static int N;
	static int[] tree;
	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		//	트리에 저장 1~N 
		N = Integer.parseInt(br.readLine());
		tree = new int[N+1];
		
		// [0] tree에 데이터 저장
		for (int i=1; i<=N; i++) {
			tree[i] = (char)('A'+i-1);
		}
		
		preOrder(1);	//	전위순회로 루트부터 탐색
	}
	
	public static void preOrder(int n) {
		//	종료조건: 1~N만 존재하는 노드
		if (1<=n && n<=N) {
			System.out.print((char)tree[n]+" ");	// 중앙: 노드에 저장된 값을 출력
			preOrder(n*2);					// left
			preOrder(n*2+1);				// right
		}
	}

}
