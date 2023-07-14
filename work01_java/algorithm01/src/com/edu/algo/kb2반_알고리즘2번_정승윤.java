package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb2반_알고리즘2번_정승윤 {
	
	static int N;
	static int K;
	static int[] arr;
	static int global;
	static int local;
	
	/*
	 * 형태는 정의함수가 먼저 정의되어 있고 그 이후에 main함수가 정의되어 있습니다.
	 * 문제 흐름상 main함수 부분의 주석과 코드를 읽으시고 정의 함수를 읽으시는 것을 추천드립니다.
	 */
	
	
	/*
	 * dfs 함수 설명
	 * index를 정하고 과정 중 합이 K보다 크면 더 이상 진행하지 않고
	 * 3개를 더한 값이 K보다 작으면 global과 비교하여 갱신하는 방법
	 * 
	 * 재귀로 들어갈수록 같은 위치의 변수를 활용하지 않기 위해
	 * idx값을 통해 index 값을 넘겨서 그 이후부터 탐색하도록 설계
	 * 
	 * 변수 설명
	 * idx = 이번 함수에서 탐색을 시작할 index
	 * cnt = 현재까지 재귀의 깊이 == 현재까지 더한 수의 개수
	 */
	static void dfs(int idx, int cnt) {
		
		// K보다 합이 작은 값들만 도착할 수 있는데 그 중 cnt가 3보다 작은 경우
		if (cnt == 3) {
			// 그 중에서도 global보다 값이 큰 경우에는 global을 갱신해줌
			if (local > global) {
				global = local;
			}
		}
		
		// idx값부터 탐색 및 연산을 진행함
		for (int i=idx; i<N; i++) {
			// idx 위치의 값을 더해줌
			local += arr[i];
			
			// 이때 이제까지의 합이 K보다 크다면 더이상 진행하지 않고 돌아옴
			if (local > K) {
				local -= arr[i];
			} 
			// 그렇지 않다면 cnt수를 늘리고 재귀를 깊게 들어가는데
			// 그 다음 탐색 및 연산은 그 다음 index부터 시작
			else {
				dfs(i+1, cnt+1);
				local -= arr[i];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		/*
		 * 1. 입력 단계
		 * DFS를 활용할 예정이기 때문에 모든 변수를 Static으로 선언해두고
		 * 그 후 초기화 하는 방법으로 입력 진행
		 * 
		 * 변수 설명
		 * N: 주어진 수의 개수
		 * K: 기준 Value
		 * arr: 주어진 수들을 저장하는 배열
		 * local: 뽑힌 3개 수의 합
		 * global: 이제까지 모든 3개 수의 합 중 가장 기준 Value보다는 작지만 가까운 수 == Answer값
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		global = 0;
		local = 0;
		
		/*
		 * 2. DFS 실행 단계
		 * static 함수로 생성 후 실행
		 * dfs 함수 정의한 부분에서 함수 구동 원리 상세 설명
		 */
		dfs(0,0);
		
		/*
		 * 3. 정답 출력 단계
		 * 최종 global 값을 최종값으로 출력
		 */
		System.out.println(global);
		
		
	}
}
