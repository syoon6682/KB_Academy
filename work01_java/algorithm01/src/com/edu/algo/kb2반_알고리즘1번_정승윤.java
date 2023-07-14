package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb2반_알고리즘1번_정승윤 {

	public static void main(String[] args) throws IOException{
		
		// 1. 데이터 입력 단계
		// 먼저 데이터의 개수 N을 입력 받고
		// N개의 데이터를 arr에 저장하는 과정 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(temp.nextToken());
		}
		
		/*
		 2. 선택 정렬 단계
		 개요: 기준점부터 끝 사이에서 가장 큰 index를 선택하고
		 기준점과 바꾸면서 정렬하는 과정
		 
		 변수 설명: 
		 i = 기준점
		 localMaxIndex: 기준점과 끝 구간 사이에 가장 큰 value Index
		 localMaxIndex: 기준점과 끝 구간 사이에 가장 큰 value
		 */
		for(int i=0; i<N; i++) {
			
			// 주어진 배열에서 최소값이 1이므로 
			// 그 다음 값인 0으로 초기화하고 주어진 구간에서 가장 큰 value 값을 탐색
			int localMaxValue = 0;
			int localMaxIndex = 0;
			for(int j=i; j<N; j++) {
				if (arr[j] > localMaxValue) {
					localMaxValue = arr[j];
					localMaxIndex = j;
				}
			}
			
			// 찾은 범위 내 가장 작은 value index와 값을 활용하여
			// 기준점과 바꾸는 과정
			int temp1 = arr[i];
			int temp2 = localMaxValue;
			arr[i] = temp2;
			arr[localMaxIndex] = temp1;
		}
		
		// 3. 정답 출력 과정 
		// 완성된 배열을 정답 형태에 맞게 출력하는 과정
		// for문을 통해 순차적으로 출력
		for (int a:arr) {
			System.out.println(a);
		}
	}
}
