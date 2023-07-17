package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1991_트리_순회 {
	static public HashMap<String, Node> hs = new HashMap<>();
	static StringBuilder preO, inO, postO;

	public static class Node{
		public String root;
		public String left = "";
		public String right = "";
		
		public String get() {
			return root;
		}
	}
	
	static void preOrder(String r) {

		preO.append(r);
		
		if(!hs.get(r).left.equals("")) {
			preOrder(hs.get(r).left);
		}
		if(!hs.get(r).right.equals("")) {
			preOrder(hs.get(r).right);
		}
	}
	
	static void inOrder(String r) {


		if(!hs.get(r).left.equals("")) {
			inOrder(hs.get(r).left);
		}
		
		inO.append(r);
		
		if(!hs.get(r).right.equals("")) {
			inOrder(hs.get(r).right);
		}
	}
	
	static void postOrder(String r) {


		if(!hs.get(r).left.equals("")) {
			postOrder(hs.get(r).left);
		}
		
		if(!hs.get(r).right.equals("")) {
			postOrder(hs.get(r).right);
		}
		
		postO.append(r);
	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			Node n = new Node();
			n.root = temp.nextToken();	
			String left = temp.nextToken();
			if (left.equals(".")) {
				n.left = "";
			} else {
				n.left = left;
			}
			
			String right = temp.nextToken();
			if (right.equals(".") ) {
				n.right = "";
			} else {
				n.right = right;
			}
			hs.put(n.root, n);
		}
		
		preO = new StringBuilder();
		preOrder("A");
		System.out.println(preO.toString());
		
		inO = new StringBuilder();
		inOrder("A");
		System.out.println(inO.toString());
		
		postO = new StringBuilder();
		postOrder("A");
		System.out.println(postO.toString());
		
	}

}
