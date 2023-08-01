package day08.dfs_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2667_단지번호붙이기 {
	static int N, cnt;
	static int[][] arr;
	static boolean[][] v;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		// [0] 입력처리
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N+2][N+2];
		v = new boolean[N+2][N+2];
		for (int i=1; i<=N; i++) {
			String line = br.readLine();
			for (int j=0; j<N; j++) {
				arr[i][j+1]=line.charAt(j)-'0';
			}
		}
//		System.out.println(Arrays.deepToString(arr));

		ArrayList<Integer> ans = new ArrayList<>();
		// [1] 전체를 순회하면서 미방문&집(==1)을 만나면 연결된 집 세기(dfs)
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (!v[i][j] && arr[i][j]==1) {
					cnt = 0;	//	dfs함수내에서 첫 방문시 ++
					dfs(i, j);
					ans.add(cnt);
				}
			}
		}
		// [2] 오름차순 정렬후, 순서대로 출력
		ans.sort(null);
		System.out.println(ans.size());
		for (int n: ans) System.out.println(n);
	}
	
	public static void dfs(int ci, int cj) {
		v[ci][cj] = true;
		cnt++;				// 첫 방문시 해야할 일
		
		for (int k=0; k<4; k++) {
			int ni = ci+di[k];
			int nj = cj+dj[k];
			if (!v[ni][nj] && arr[ni][nj]==1) dfs(ni,nj);
		}
	}
}







