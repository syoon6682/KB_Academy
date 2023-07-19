package com.edu.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ11723_집합 {
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> fullSet = new HashSet<>();

		for (int i=1; i<=20; i++) {
			fullSet.add(i);
		}
		
		int N = Integer.parseInt(st.nextToken());
		
		
		for (int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			String method = temp.nextToken();
			
			switch(method) {
			case "add": 
				int num = Integer.parseInt(temp.nextToken());
				set.add(num);
				break;
			case "remove": 
				num = Integer.parseInt(temp.nextToken());
				if (set.contains(num)) {
					set.remove(num);
				}
				break;
			case "check": 
				num = Integer.parseInt(temp.nextToken());
				
				if (set.contains(num)) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
				break;
			case "toggle": 
				num = Integer.parseInt(temp.nextToken());
				if (set.contains(num)) {
					set.remove(num);
				} else {
					set.add(num);
				}
				break;
			case "all": 
				set = (HashSet<Integer>) fullSet.clone();
				
				break;
			case "empty": 
				set.clear();
				break;
			}
				
		}
		bw.flush();
		bw.close();
	}

}
