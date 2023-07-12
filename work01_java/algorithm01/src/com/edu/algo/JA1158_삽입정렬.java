package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JA1158_삽입정렬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		StringTokenizer list = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(list.nextToken());
		}
		
		int idx = 0;
		while (idx < n) {
			int temp = idx;
			while(true) {
				if (temp==0) {
					break;
				} else{
					if(arr[temp] < arr[temp-1]) {
						int temp1 = arr[temp];
						int temp2 = arr[temp-1];
						arr[temp] = temp2;
						arr[temp-1] = temp1;
						temp -= 1;
					} else {
						break;
					}
				}
			}
			if (idx != 0) {
				for(int i=0; i<n; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();	
			}
			idx += 1;
		}
		
	}

}
