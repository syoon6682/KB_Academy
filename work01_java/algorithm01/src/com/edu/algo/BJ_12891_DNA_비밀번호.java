package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer; 

public class BJ_12891_DNA_비밀번호 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken()); 
		int P = Integer.parseInt(st.nextToken()); 
	
		String word = br.readLine();
		char[] wordArr = word.toCharArray();
		
		StringTokenizer acgt = new StringTokenizer(br.readLine());
		int[] acgtArr = new int[4];
		for(int i = 0; i < 4; i++) {
			acgtArr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] nowList = new int[4];
		
		int s = 0;
		int e = P-1;
		
		for(int i = 0; i < P; i++) {
			if (wordArr[i] == 'A') {
				acgtArr[0] += 1;
			}
			else if (wordArr[i] == 'C') {
				acgtArr[1] += 1;
			}
			else if (wordArr[i] == 'G') {
				acgtArr[2] += 1;
			}
			else if (wordArr[i] == 'T') {
				acgtArr[3] += 1;
			}
		}
		
		int cnt = 0;
	}

}
