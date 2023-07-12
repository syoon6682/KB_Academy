package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JA1146_선택정렬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		StringTokenizer list = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(list.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			
			int subMin = 101;
			int minIdx = 101;
			for(int j=i; j<n; j++) {
				if (arr[j] < subMin) {
					subMin = arr[j];
					minIdx = j;
				}
			}
			int temp1 = arr[i];
			int temp2 = arr[minIdx];
			arr[i] = temp2;
			arr[minIdx] = temp1;
			
			if (i==n-1) {
				continue;
			} else {
				for(int j=0; j<n; j++) {
					System.out.print(arr[j] + " ");
				}
				System.out.println();
			}
			
		}

	}

}
