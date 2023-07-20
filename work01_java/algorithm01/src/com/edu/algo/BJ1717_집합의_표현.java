package com.edu.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1717_집합의_표현 {
	static int[] arr;
	
	static int find(int f) {
		if (arr[f] == f) {
			return f;
		} 
		return arr[f] = find(arr[f]);
	}

	
	static void union(int b, int c) {
		arr[find(c)] = arr[find(b)];
	}
	
	
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n+1];
		for(int i=1; i<n+1; i++) {
			arr[i] = i;
		}
		
		for (int i=0; i<m; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(temp.nextToken());
			int b = Integer.parseInt(temp.nextToken());
			int c = Integer.parseInt(temp.nextToken());
			
			if (a==0) {
				union(b, c);	
			} else {
				int rootB = find(b);
				int rootC = find(c);
				
				if((rootB == rootC)) {
					bw.write("YES\n");
				} else {
					bw.write("NO\n");
				}
			}
		}
		bw.flush();
		bw.close();

	}

}

