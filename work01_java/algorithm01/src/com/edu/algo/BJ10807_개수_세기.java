package com.edu.algo;

import java.util.Scanner;
import java.util.Arrays;

public class BJ10807_개수_세기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		
		int[] numList = new int[N];
		
		for(int i = 0; i < N; i++) {
			numList[i] = sc.nextInt();
		}
		
		int v = sc.nextInt();
		int cnt = 0;
		for(int num: numList) {
			if(v == num) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
