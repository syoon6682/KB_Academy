package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb2반_알고리즘3번_정승윤 {

	static String[][] arr;
	static int win;
	
	/*
	 * 형태는 정의함수가 먼저 정의되어 있고 그 이후에 main함수가 정의되어 있습니다.
	 * 문제 흐름상 main함수 부분의 주석과 코드를 읽으시고 정의 함수를 읽으시는 것을 추천드립니다.
	 */
	
	/*
	 * 1이 승리를 했는지 안했는지 판단하는 Method
	 * 방향을 설정하는 delta를 우, 하, 양 대각선의 한 방향만 설정
	 * 그 후 기준점을 중심으로 delta를 더한 점의 성립 여부, delta를 뺀 점의 성립 여부를 
	 * 모두 카운트 한 뒤에 그 cnt 값이 5가 딱 나오면 승리로 설정하고 return을 통해 종료
	 */
	static int[] oneSearch() {
		// 4방향 delta 설정
		int[] dx = {1, 0, 1, 1};
		int[] dy = {0, 1, 1, -1};
		
		// 우승을 하지 못했을 때 return을 하기 위한 임의의 int[]
		int[] t= new int[2];
		
		// 2차원 배열 순회 진행
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				
				// 이때 해당 점이 1이라면 검사 시작
				if (arr[i][j].equals("1")){
					// 자기 자신을 카운트
					int cnt = 1;
					// 설정한 delta를 기준으로 방향 설정
					// bigger 변수들은 설정한 방향의 정방향,
					// smaller 변수들은 설정한 방향의 역방향을 탐색
					for(int k=0; k<4; k++) {
						int biggerX = i + dx[k];
						int biggerY = j + dy[k];
						int smallerX = i - dx[k];
						int smallerY = j - dy[k];
						
						// 순회를 빠져나오기 위한 장치 flag 
						boolean flag = false;
						
						while (true) {
							flag = true;
							
							// bigger 위치의 판단
							if (biggerX >= 0 && biggerX < 19 && biggerY >= 0 && biggerY < 19 && arr[biggerX][biggerY].equals("1")) {
								cnt++;
								biggerX += dx[k];
								biggerY += dy[k];
								flag = false;
							}
							
							// smaller 위치의 판단
							if (smallerX >= 0 && smallerX < 19 && smallerY >= 0 && smallerY < 19 && arr[smallerX][smallerY].equals("1")) {
								cnt++;
								smallerX -= dx[k];
								smallerY -= dy[k];
								flag = false;
							}
							
							// 만약 저 if문들을 아무곳도 들리지 않았다면 flag는 그대로 true이므로
							// while 문을 빠져나오게 됨
							if(flag) {
								break;
							}		
						}
					}
					
					// 만약 cnt가 정확하게 5라면 win 변수를 통해 우승자를 등록하고
					// 해당하는 xy값을 리턴
					if (cnt == 5) {
						win = 1;
						int[] answer = {i+1, j+1};
						return answer;	
					}
				}
			}
		}
		
		// 우승 조건을 찾지 못하면 아까 선언한 변수를 리턴
		return t;
	}
	
	static int[] twoSearch() {
		int[] dx = {1, 0, 1, 1};
		int[] dy = {0, 1, 1, -1};
		
		int[] t= new int[2];
		
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if (arr[i][j].equals("2")) {
					int cnt = 1;
					for(int k=0; k<4; k++) {
						int biggerX = i + dx[k];
						int biggerY = j + dy[k];
						int smallerX = i - dx[k];
						int smallerY = j - dy[k];
						boolean flag = false;
						
						while (true) {
							flag = true;
							if (biggerX >= 0 && biggerX < 19 && biggerY >= 0 && biggerY < 19 && arr[biggerX][biggerY].equals("2")) {
								cnt++;
								biggerX += dx[k];
								biggerY += dy[k];
								flag = false;
							}
							
							if (smallerX >= 0 && smallerX < 19 && smallerY >= 0 && smallerY < 19 && arr[smallerX][smallerY].equals("2")) {
								cnt++;
								smallerX -= dx[k];
								smallerY -= dy[k];
								flag = false;
							}
							
							if(flag) {
								break;
							}
						}
					}
					if (cnt == 5) {
						win = 2;
						int[] answer = {i+1, j+1};
						return answer;	
					}
				}		
			}
		}
		return t;
	}
	
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 입력 단계
		 * 19x19의 String array로 저장하고
		 * 누가 이겼는지 기록하는 win값을 Static 변수로 저장 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new String[19][19];
		for(int i=0; i<19; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());	
			for(int j=0; j<19; j++) {
				arr[i][j] = temp.nextToken();
			}
		}
		
		win = 0;
		
		/*
		 * 2. 메소드 활용을 통한 승리 탐색 단계
		 * 2차원 배열 탐색을 통해 진행
		 * oneSearch 메소드 주석을 통해 상세 설명
		 */
		
		/*
		 * 3. 답 출력 
		 * win에 기록된 승자를 기준으로
		 * 답에서 요구하는 형태로 변형하여 출력 진행
		 */
		
		int[] oneAnswer = oneSearch();
		if (win==1) {
			System.out.println(win);
			System.out.println(oneAnswer[0] + " " + oneAnswer[1]);
		} else {
			int[] twoAnswer = twoSearch();
			if(win==2) {
				System.out.println(win);
				System.out.println(twoAnswer[0] + " " + twoAnswer[1]);
			} else {
				System.out.println(win);
			}
		}
		
	


	}
}

