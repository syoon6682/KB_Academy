package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb2반_알고리즘1번_정승윤 {
	
	/*
	 * 문제 풀이 설명
	 * 1. 유니온 파인드 알고리즘을 활용하여 집합을 구성
	 * 2. 철수는 1번이고 철수의 친구들은 같은 집합을 의미하므로 find(1)을 통해 철수가 속한 집합을 구한뒤 
	 * 순회와 find함수를 활용해 철수와 같은 집합의 사람들을 카운트하여 출력합니다.
	 */
	
	// 변수 static 화
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// BufferedReader를 활용한 변수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		// 사람의 수 입력
		N = Integer.parseInt(st1.nextToken());
		// 사람들을 저장할 배열 생성
		arr = new int[N+1];
		
		// 각각 독립된 집합을 가지기 위한 for문
		for (int i=1; i<N+1; i++) {
			arr[i] = i;
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		// 집합 관계 개수 입력
		M = Integer.parseInt(st2.nextToken());
		
		// for문을 통해 M번 받으며 이때 받는 a와 b가 친구 관계, 
		// 즉, 집합 관계이므로 union 함수를 활용하여 같은 집합으로 묶어주기
		for (int i=0; i<M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st3.nextToken());
			int b = Integer.parseInt(st3.nextToken());
			
			union(a, b);
		}
		
		// std: 기준이 되는 변수로 철수의 집합을 저장함
		int std = find(1);
		// 철수의 친구들을 기록할 cnt 변수
		int cnt = 0;
		
		// 철수 빼고 순회를 시작하므로 2로 시작하는데
		for (int i=2; i<N+1; i++) {
			// 만약 너가 철수랑 같은 집합이라면
			if (find(arr[i]) == std) {
				// 난 너를 세어줄거야
				cnt++;
			}
		}
		
		// 철수를 센 cnt 함수를 정답으로 출력
		System.out.println(cnt);
		
	}
	
	// 유니온 파인드 함수 중 파인드 함수
	// skewed tree로 이루어진 관계에서 top node를 찾아줄 뿐만 아니라
	// 중간에 만난 node들도 top node로 향하게 해주는 로직입니다.
	static int find(int f) {
		// 만약 너가 정점이라면
		if (arr[f] == f) {
			// 그냥 널 return해
			return f;
		// 근데 그렇지 않다면
		} else {
			// 재귀를 통해 최상위를 return하면서 중간에 만나는 친구들도 다 최상위로 바꿔줘
			return f = find(arr[f]);
		}
		
	}
	
	// 유니온 파인드 함수 중 유니온 함수
	// 두 요소를 하나의 집합으로 묶어주는 함수
	// 이때 find 함수를 활용하여 서로의 집합에 있는 다른 친구들도 같은 집합에 묶일 수 있게 해줌
	static void union(int a, int b) {
		arr[find(a)] = arr[find(b)];
	}

}
