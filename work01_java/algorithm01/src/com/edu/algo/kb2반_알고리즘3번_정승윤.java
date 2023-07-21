package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb2반_알고리즘3번_정승윤 {
	
	/*
	 * 문제 풀이 설명
	 * 1. 깊이가 최대 10이므로 dfs, 완전이진트리 방식을 활용하여 전체 탐색
	 * 2. 마지막에 기록된 local 값이 global 값보다 높으면 갱신해나가고
	 * 3. 마지막 저장된 global 값을 출력
	 */
	
	// 변수 static 화
	static int N;
	static int M;
	static int global;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		// 변수 입력 단계
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 구간 길이와 주어진 시간 입력 받기
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		
		// 구간별 커지는 값을 arr에 저장
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		// global 초기화
		global = 0;
		
		// dfs(현재 위치, 진행 시간, 현재 크기) 인데 
		// 문제에서 주어진 구간의 1번째 위치는 배열에서 0번째 위치이고
		// 현재 나는 0번째 위치에 있다고 했으므로 -1로 시작
		dfs(-1, 0, 1);
		
		// 최종 갱신된 global를 return
		System.out.println(global);
	}
	
	/*
	 * n: 현재 위치
	 * m: 현재 시간
	 * local: 이제까지의 크기
	 */
	static void dfs(int n, int m,  int local) {
		// 만약 구간을 넘어버리거나 시간이 다되면
		if (n >= N || m > M) {
			// global과 비교해서 높으면
			if (local > global) {
				// 갱신
				global = local;
			}
		} 
		// 아니라면
		else { 
			// 한칸 뛰어가거나
			if (n+1 < N) {
				int local1 = local + arr[n+1];
				dfs(n+1, m+1, local1);
			}
			
			// 2칸 뛰고 중간으로 줄어들거나
			if (n+2 < N) {
				int local2 = local/2 + arr[n+2];
				dfs(n+2, m+1, local2);
			}
			
			
			
			// 그 두 경우를 둘 다 깊게 들어가보자 
			
			
		}
	}

}
