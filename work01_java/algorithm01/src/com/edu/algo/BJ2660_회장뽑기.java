package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BJ2660_회장뽑기 {
	
	public static class Node{
		public ArrayList<Integer> friend = new ArrayList<>();
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Node> nodes = new ArrayList<>();
		
		for (int i=0; i<n+1; i++) {
			nodes.add(new Node());
		}
		
		while (true) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st2.nextToken());
			int e = Integer.parseInt(st2.nextToken());
			
			if (s==-1 || e==-1) {
				break;
			}
			
			nodes.get(s).friend.add(e);
			nodes.get(e).friend.add(s);
		}
		
		for (Node no : nodes) {
			System.out.println(no.friend);
		}
	}

}
