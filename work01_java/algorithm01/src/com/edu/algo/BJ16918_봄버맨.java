package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16918_봄버맨 {
	
	public static void main(String[] args) throws IOException {
		/*
		 * 문제 설계
		 * 변수를 2차원 int 배열로 받고 조건에 맞추어 풀이
		 * 이때 빈칸을 4, 그리고 1, 2, 3을 활용하여 남은 터지는 시간 기록
		 * 
		 * 본 문제는 뭔가 이번 자바 수업을 잘 활용해보고 싶어서 기능 분리를 많이 했습니다.
		 * 간단하게 로직을 이해하기 위해 main을 위주로 읽으시면 좋을 거 같습니다.
		 */
		
		/*
		 * 변수 입력 단계
		 * 변수는 모두 static으로 올려버리고 입력 받기 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		// map 저장 단계
		// 빈칸의 경우, 4
		// 그렇지 않다면 3을 저장
		for (int i=0; i<R; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String str = st2.nextToken();
			for(int j=0; j<C; j++) {
				char temp = str.charAt(j);
				if (temp == '.') {
					map[i][j] = 4;
				} else {
					map[i][j] = 3;
				}
			}	
		}
		
		// 진행 횟수를 저장하는 cnt
		int cnt = 0;
		
		// 목표 진행횟수에 도달할 때까지 while문 진행
		/*
		 * 함수 정보 
		 * descentNum: 남은 시간 1초 차감
		 * fillBomb: 빈칸을 폭탄으로 채움
		 * explode: 폭탄 터트림
		 * findZero: 터트려야 하는 폭탄의 위치 return
		 */
		while (cnt < N) {
			cnt++;
			if (cnt==1) {
				descentNum();
				continue;
			} else {
				descentNum();
				fillBomb();
				explode(findZero());
			}
		}
		
		// 정답을 올바른 양식으로 출력하기 위한 intToString과 PrintMap
		String[] answer = intToString();
		printMap(answer);
		
	}
	
	
	
	static int R;
	static int C;
	static int N;
	static int map[][];
	
	// 빈칸(4)이면 넘어가고 폭탄이면(1,2,3) 1초 차감
	static void descentNum() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] == 4) {
					continue;
				} else {
					map[i][j] -= 1;
				}
			}
		}
	}
	
	// 빈칸(4)이면 새로운 폭탄 채우기 (3으로 채우기)
	static void fillBomb() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] == 4) {
					map[i][j] = 3;
				}
			}
		}
	}
	
	// 터지는 위치를 ArrayList에 int배열을 추가하여 진행
	static ArrayList<int[]> findZero(){
		ArrayList<int[]> answer = new ArrayList<>();
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] == 0) {
					int[] temp = {i, j};
					answer.add(temp);
				}
			}
		}
		return answer;
	}
	
	// 받은 배열을 기준으로 폭파시키기
	// 이때 4방향 Delta 활용
	static void explode(ArrayList<int[]> zero) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		for (int[] z : zero) {
			int x = z[0];
			int y = z[1];
			map[x][y] = 4;
			for (int i=0; i<4; i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				if(newX>=0 && newX<R && newY>=0 && newY<C) {
					map[newX][newY] = 4;
				}			
			}
		}
	}
	
	// 2차원 int 배열이었던 map을 답 제출을 위해 1차원 String 배열로 바꾸기
	static String[] intToString() {
		String[] answer = new String[R];
		for (int i=0; i<R; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j=0; j<C; j++) {
				if(map[i][j] == 4) {
					sb.append(".");
				} else {
					sb.append("O");
				}
			}
			answer[i] = sb.toString();
		}
		return answer;
	}
	
	// 답 제출 형식으로 출력하기
	static void printMap(String[] answer) {
		for (String s : answer) {
			System.out.println(s);
		}
	}
}