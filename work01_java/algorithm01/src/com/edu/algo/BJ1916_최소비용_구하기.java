package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1916_최소비용_구하기 {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st2.nextToken());
		HashMap<Integer, HashMap<Integer, Integer>> info = new HashMap<>();
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i=0; i<M; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(temp.nextToken());
			int e = Integer.parseInt(temp.nextToken());
			int l = Integer.parseInt(temp.nextToken());
			
			if(!info.keySet().contains(s)) {
				info.put(s, new HashMap<Integer, Integer>());
			}
			info.get(s).put(e, l);
			
			if(!info.keySet().contains(e)) {
				info.put(e, new HashMap<Integer, Integer>());
			}
			info.get(e).put(s, l);	
		}
		
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st3.nextToken());
		int end = Integer.parseInt(st3.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		hs.add(start);
		
		while(hs.size() < N) {
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				
			}
		}
		
	}

}
