package com.edu.algo;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

class Dfs{
	public int x;
	public int y;
	public int R;
	public int C;
	public char[][] map;
	public int max = 1;
	public HashSet<Character> set;
	
	public void dfs() {	
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		for(int i=0; i<4; i++) {
			int new_x = x + dx[i];
			int new_y = y + dy[i];
			if(new_x >= 0 && new_x<R && new_y >= 0 && new_y<C) {
				if (!set.contains(map[new_x][new_y])){
					x += dx[i];
					y += dy[i];
					set.add(map[x][y]);
					if (set.size() > max) {
						max = set.size();
					}
					this.dfs();
					set.remove(map[x][y]);
					x -= dx[i];
					y -= dy[i];
				}
			}
		}
	}
}


public class BJ1987_알파벳 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		HashSet<Character> set = new HashSet<>();
		
		char[][] map = new char[R][C];
		for(int i=0; i<R; i++) {
			String temp = sc.next();	
			map[i] = temp.toCharArray();
		}
		
		int x = 0;
		int y = 0;
		set.add(map[x][y]);
		
		Dfs d = new Dfs();
		d.x = x;
		d.y = y;
		d.R = R;
		d.C = C;
		d.map = map;
		d.set = set;
		
		d.dfs();
		System.out.println(d.max);		
	}
}
