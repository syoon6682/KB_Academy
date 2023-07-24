package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1414_불우이웃돕기 {
	
	static int[] arr;
	
	static class Node{
		public int start;
		public int end;
		public int cost;
		
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
	}
	
	static int justFind(int n) {
		if (arr[n] == n) {
			return n;
		}
		return find(arr[n]);
	}
	
	static int find(int n) {
		if (arr[n] == n) {
			return n;
		}
		return arr[n] = find(arr[n]);
	}
	
	static void union(int a, int b) {
		arr[find(a)] = arr[find(b)];
	}

	public static void main(String[] args) throws IOException {
		
		// 입력 단계
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 컴퓨터 수 입력 및 독립된 집합을 가지도록 배열 초기화
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = i;
		}
		
		// 랜선 정보를 저장할 2차원 배열 map
		int[][] map = new int[N][N];
		
		// 랜선 정보 저장 및 전체 랜선 길이 계산
		
		/*
		 * char는 아스키코드에 따라 int value를 가지고 있는 점을 활용
		 * 소문자 a는 97이고 b=98, c=99 ...
		 * 대문자 A는 65, B = 66, C = 67 ...
		 * char 0은 48
		 */ 
		int totalSum = 0;
		for (int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String temp = st2.nextToken();
			
			for (int j=0; j<N; j++) {
				int n = Integer.valueOf(temp.charAt(j)) - 96;
				if (n == -48) {
					n = 0;
				} 
				else if (n <= 0) {
					n += 58;
				}
				map[i][j] = n;
		
				// 랜선 총합 저장
				totalSum += n;
			}
		}

		// 우선순위 큐를 활용한 정렬
		
		/*
		 * 우선순위 큐는 Queue와 비슷한 구조이나
		 * 나올 때 우선순위에 따라 나오는 객체가 나옴
		 * 해당 우선순위 큐는 Node의 Cost 낮은 것부터 pop 되도록 선언
		 */
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
		
		
		// map의 정보를 기반으로 우선순위 큐 삽입
		
		/*
		 * 이때 map이 0일 경우 랜선이 없음을 의미.
		 * 그래서 양쪽 다 0이면 연결이 아예 없으므로 넘기고
		 * 한쪽이 0이면 다른 한쪽을 삽입하고
		 * 둘다 랜선이 존재한다면 낮은 cost를 가진 랜선을 삽입
		 */
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				
				if (map[i][j] == 0 && map[j][i] == 0) {
					continue;
				} else if (map[i][j] == 0) {
					q.add(new Node(j, i, map[j][i]));
				} else if (map[j][i] == 0) {
					q.add(new Node(i, j, map[i][j]));
				} else if (map[i][j] > map[j][i]) {
					q.add(new Node(j, i, map[j][i]));
				} else {
					q.add(new Node(i, j, map[i][j]));
				}
				
			}
		}
		
		
		/*
		 * 변수 설명
		 * cnt: N-1개의 간선이 존재해야 하므로 간선 추가 개수를 세기 위한 변수
		 * lan: 이제껏 뺀 lan선의 길이
		 * flag: 모든 컴퓨터를 연결하지 못했는데 주어진 랜선을 모두 쓰면 연결이 불가능한데 그 여부를 알려주는 변수
		 */
		int cnt = 0;
		int lan = 0;
		boolean flag = true;
		while (cnt < N-1) {
			
			// 아직 랜선 연결하는 중인데 모든 랜선을 다 쓰면 탈출하고 flag = false
			if (q.isEmpty()) {
				flag = false;
				break;
			}
			
			// test할 랜선 뽑아내서
			// 만약 같은 집합이 아니라면 같은 집합으로 합치고 cnt ++
			Node temp = q.poll();
			if(justFind(temp.start) != justFind(temp.end)) {
				union(temp.start, temp.end);
				lan += temp.cost;
				cnt++;
			}
			
			
		}
		
		
		// 만약 다 연결이 안되면 -1, 연결이 되면 전체 랜선수 - 필요한 랜선 수 
		if(flag) {
			System.out.println(totalSum - lan);
		} else{
			System.out.println(-1);
		}

	}

}
