package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
			acgtArr[i] = Integer.parseInt(acgt.nextToken());
		}
		
		
		int[] nowList = new int[4];
		
		int s = 0;
		int e = P;
		int cnt = 0;
		
		for(int i = 0; i < P; i++) {
			if (wordArr[i] == 'A') {
				nowList[0] += 1;
			}
			else if (wordArr[i] == 'C') {
				nowList[1] += 1;
			}
			else if (wordArr[i] == 'G') {
				nowList[2] += 1;
			}
			else if (wordArr[i] == 'T') {
				nowList[3] += 1;
			}
		}
		
		if (nowList[0] >= acgtArr[0] & nowList[1] >= acgtArr[1] & nowList[2] >= acgtArr[2] & nowList[3] >= acgtArr[3]) {
			cnt += 1;
		}
		
		
		while(e < S) {
			if (wordArr[s] == 'A') {
				nowList[0] -= 1;
			}
			else if (wordArr[s] == 'C') {
				nowList[1] -= 1;
			}
			else if (wordArr[s] == 'G') {
				nowList[2] -= 1;
			}
			else if (wordArr[s] == 'T') {
				nowList[3] -= 1;
			}

			
			if (wordArr[e] == 'A') {
				nowList[0] += 1;
			}
			else if (wordArr[e] == 'C') {
				nowList[1] += 1;
			}
			else if (wordArr[e] == 'G') {
				nowList[2] += 1;
			}
			else if (wordArr[e] == 'T') {
				nowList[3] += 1;
			}
			
			if (nowList[0] >= acgtArr[0] & nowList[1] >= acgtArr[1] & nowList[2] >= acgtArr[2] & nowList[3] >= acgtArr[3]) {
				cnt += 1;
			}
			
			s++;
			e++;
			
		}
		
		System.out.println(cnt);
		
	}

}
