package com.edu.loop.test;

public class BasicLoopTest1 {
	
	public static void main(String args[]){
		System.out.println("====== for ======");
		for (int i=0; i<10; i++) { // 이때 i는 지역변수, local variable로서 for문 안에서만 쓰임, for문 밖으로 나가면 i는 없어짐 -> temporary 변수, 자동적으로 사라지므로 automatically 변수라고도 함
			System.out.println("i: " + i);
		}
		
		System.out.println("====== while ======");
		
		int i = 10;
		while(i>0) {
			System.out.println("i: " + i);
			i--;
		}
	}

}
