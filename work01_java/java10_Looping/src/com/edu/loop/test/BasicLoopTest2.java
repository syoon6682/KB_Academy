package com.edu.loop.test;

/*
 * if문과 함께 사용되는 반복문의 키워드
 * if + break
 * if + continue
 */

public class BasicLoopTest2 {
	
	public static void main(String args[]){
		int total = 0;

		
//		System.out.println("====== break ======");
//		for (int member=0; member<10; member++) { // 이때 i는 지역변수, local variable로서 for문 안에서만 쓰임, for문 밖으로 나가면 i는 없어짐 -> temporary 변수, 자동적으로 사라지므로 automatically 변수라고도 함
//			if(total>=30) break;
//			total += member;
//		}
//		
//		System.out.println(total);
		
		System.out.println("====== continue ======");
		for (int num=1; num<=10; num++) {
			if(num % 2 == 0) continue;
			total += num;
		}
		System.out.println(total);

	}

}
