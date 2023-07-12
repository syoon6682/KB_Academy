package com.edu.algo;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1629_곱셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(A==1) {
			System.out.println(1);
		} else {
			int idx = 1;
			int finder = 1;
			while(true) {
				idx++;
				finder *= 2;
				if(A<finder) {
					break;
				}
			}
			
			int[] arr = new int[idx];
			int temp = A;
			temp %= C;
			
			for(int i=1; i<idx; i++) {
				arr[i] = A;
				temp = (temp*temp)%C;
			}
			
			for(int i=idx-1; i>0; i--) {
				
			}
		
			System.out.println(Arrays.toString(arr));
		}
	}
}
