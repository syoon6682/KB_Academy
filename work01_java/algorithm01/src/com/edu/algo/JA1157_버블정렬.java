package com.edu.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class JA1157_버블정렬 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		StringTokenizer list = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(list.nextToken());
		}
		
		for(int j=n-1; j>0; j--) {
			for(int i=0; i<j; i++) {
				if(arr[i] > arr[i+1]) {
					int temp1= arr[i];
					int temp2 = arr[i+1];
					arr[i] = temp2;
					arr[i+1] = temp1;
				}
			
			}
			

			for(int i=0; i<n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
					
		}
	}
}


