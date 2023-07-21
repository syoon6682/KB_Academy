package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kb2반_알고리즘2번_정승윤 {
	
	/*
	 * 문제 풀이 설명
	 * 1. 문제 입력 단계에서 총 학생 수를 저장하며 입력 받습니다. 
	 * 2. 가장 처음 아픈 친구를 시작점으로 퍼져나가는 모습입니다.
	 * -> 다시 말해, 주변부터 체크해나가는 BFS가 유리한 문제
	 * 3. 그래서 아픈 친구를 기준으로 BFS를 실시하여 걸리는 시간과 걸리는 사람들을 체크합니다.
	 * 4. 이때 처음 걸리는 친구도 코로나에 걸리는데 1일을 소모하는 로직을 활용했으므로 총 걸린 시간 + 2
	 * 5. 총 학생수 - 걸린 학생 수 = 건강한 학생 이라는 로직을 활용하여 답 출력
	 */
	
	// 변수 static 화
	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		// 변수 입력 단계
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		// 이때 가로와 세로가 반대로 주어져서 역순으로 입력 받기
		M = Integer.parseInt(st1.nextToken());
		N = Integer.parseInt(st1.nextToken());
		
		// 학생 배치도를 저장할 map 2차원 배열
		map = new int[N][M];
		// 총 학생수를 저장할 변수
		int	totalStudent = 0;
		
		// map 저장 단계
		
		
		for (int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			// 이때 모든 입력값이 하나로 붙어 있으므로 String으로 받고
			String temp = st2.nextToken();
			for (int j=0; j<M; j++) {
				// 하나하나의 위치를 charAt 메서드로 찾아낸뒤
				// getNumericValue 메서드를 활용하여 integer화 진행
				map[i][j] = Character.getNumericValue(temp.charAt(j));
				// 이때 저장한 값이 1이라면 총 학생수 +1
				if (map[i][j] == 1) {
					totalStudent++;
				}
			}
		}
		
		// 시작점 입력 단계
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		int startY = Integer.parseInt(st3.nextToken());
		int startX = Integer.parseInt(st3.nextToken());
		
		// BFS를 진행하고 {총 걸린 시간, 걸린 학생 수} 리턴 받기
		int[] answer = bfs(startX, startY);
		
		// 정답 출력 단계
		System.out.println(answer[0]);
		System.out.println(totalStudent - answer[1]);
		
	}
	
	/*
	 * 기본 방향성
	 * 확진된 학생은 0으로 만들면서 4방향으로 뻗어가는 BFS
	 * 이때 걸린 학생수와 걸린 시간을 저장하면서 진행합니다.
	 */
	static int[] bfs(int x, int y) {
		// 검사할 학생들의 좌표를 저장할 Queue
		Queue<int[]> q = new LinkedList<>();
		
		// 상하좌우 방향성을 부여할 delta
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		// 입력받은 시작점
		int[] start = {x, y};
		
		// 시작점 Queue에 넣기
		q.add(start);
		// 시작점은 0으로 바꾸기
		map[x][y] = 0;
		
		// Queue에 아무것도 없으면 좌표에 대한 모든 검사가 끝났다는 의미이므로
		// while 탈출 조건문으로 활용하기 위한 qSize 저장
		int qSize = q.size();
		
		// 걸린 날을 저장할 cnt
		int cnt = 0;
		
		// 걸린 학생 수를 저장할 corona
		int corona = 0;
		
		// Queue의 크기가 0보다 큰 동안 반복문을 돌릴건데
		while (qSize > 0) {
			
			// 추가되는 검사 대상들의 영향을 받지 않도록 qSize로 반복문 횟수 지정해주기
			for (int i=0; i<qSize; i++) {
				// 검사 대상 입장
				int[] temp = q.poll();
				
				// 좌표 저장
				x = temp[0];
				y = temp[1];
				
				// 걸린 사람이므로 corona + 1
				corona += 1;
				
				// 이제 4방향 탐색을 할건데
				for (int j=0; j<4; j++) {
					
					// 아까 준비한 delta값을 더해보고
					int newX = x + dx[j];
					int newY = y + dy[j];
					
					// 새로운 x와 y가 범위 안에 존재하고, 그 학생이 코로나라면
					if (newX>=0 && newX < N && newY>=0 && newY < M && map[newX][newY] == 1) {
						// 넌 검사 받아야겠다.
						int[] point = {newX, newY};
						q.add(point);
						
						// 그리고 다시 들리지 않도록 0으로 바꿔주기
						map[newX][newY] = 0;
					}
				}
			}
			// 검사가 한턴 끝나면 하루가 지나므로 cnt +1
			cnt++;
			// Queue size 갱신
			qSize = q.size();
		}
		
		// 나온 답을 {걸린 날, 걸린 학생 수} 배열로 저장
		// 이때 첫 환자가 발생하는 경우에도 하루가 지났다고 처리한 로직이므로 +3이 아닌 +2를 해줌
		int[] answer = {cnt+2, corona};
		
		// answer return
		return answer;
	}

}
