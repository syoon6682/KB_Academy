package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

import javax.xml.namespace.QName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2660_회장뽑기 {

	public static void main(String[] args) throws IOException {
		// 입력 단계
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		nodes = new ArrayList<>();
		
		// 인원 정보 초기화
		for (int i = 0; i < n + 1; i++) {
			nodes.add(new Node());
		}
		
		// 친구 관계 정보
		while (true) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st2.nextToken());
			int e = Integer.parseInt(st2.nextToken());
			
			// 입력값이 이러면 나오렴
			if (s == -1 || e == -1) {
				break;
			}
			
			// 너는 내 친구, 나도 네 친구
			nodes.get(s).friend.add(e);
			nodes.get(e).friend.add(s);
		}
		
		// 정답배열 만들고
		ArrayList<Integer> answer = new ArrayList<>();
		
		// 사람마다 관계수를 for문을 통해 구하는데
		for (int i = 1; i < n + 1; i++) {
			
			// 너의 친구 관계 수가
			int local = bfs(i);
			
			// 이제까지 관계수보다 작으면
			if (local < global) {
				global = local;
				answer.clear();
				answer.add(i);
			} 
			// 똑같으면 그냥 추가해줘
			else if (global == local) {
				answer.add(i);
			}
		}
		
		// 정답 출력 단계
		System.out.println(global + " " + answer.size());
		for (int a : answer) {
			System.out.print(a + " ");
		}

	}
	
	// 친구관계를 저장하기 위한 Node 클래스
	// 필드 하나밖에 없는데 나 왜 이렇게 함?
	// 근데 바꾸자니 너무 많이 바뀌어서 pass..
	public static class Node {
		public ArrayList<Integer> friend = new ArrayList<>();
	}
	
	// 변수의 static화
	// 최대 인원이 50명이므로 51을 초기값으로 설정하고 갱신해나감
	// Node List를 만들어서 n번 인덱스에는 n번 사람의 정보가 들어가도록 하기
	static int n;
	static int global = 51;
	static ArrayList<Node> nodes;
	
	
	// 친구 관계를 카운트하는 bfs
	// 관계 수를 return하도록 설계
	// 근데 visited 설계를 set으로 함 -> 모든 사람을 전부 집어넣고 방문할때마다 제거하는 방법
	// set이 비면 모두 친구관계로 연결된 걸로 
	// 중간중간 주석을 넣으면 가독성이 좀 떨어지는 거 같아서 코드의 자세한 설명은 스터디 시간에 할게요!
	static int bfs(int t) {
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 1; i < n + 1; i++) {
			visited.add(i);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(t);
		visited.remove(t);
		int cnt = 0;
		int qSize = q.size();
		while (!visited.isEmpty()) {
			for (int i = 0; i < qSize; i++) {
				int test = q.poll();
				ArrayList<Integer> fri = nodes.get(test).friend;
				for (int f : fri) {
					if (visited.contains(f)) {
						visited.remove(f);
						q.add(f);
					}
				}
			}
			cnt++;
			qSize = q.size();
		}
		return cnt;
	}

}
