package com.edu.algo;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class BJ2164_카드_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if (N==1) {
			System.out.println(N);
		} else {
			Queue<Integer> queue = new LinkedList();
			
			for(int i=1; i<N+1; i++) {
				queue.add(i);
			}
			
			while(true) {
				queue.poll();
				if(queue.size() == 1) {
					break;
				}
				int temp = queue.poll();
				queue.add(temp);
			}		
			System.out.println(queue.poll());
		}	
	}
}
