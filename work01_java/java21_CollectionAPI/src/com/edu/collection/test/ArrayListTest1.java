package com.edu.collection.test;

import java.util.ArrayList;
import java.util.List;

/*
 * ArrayList
 * ::
 * 순서O
 * 중복 허용
 */

public class ArrayListTest1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("신동엽");
		list.add("이수근");
		list.add("강호동");
		list.add("신동엽");
		list.add("탁재훈");
		
		System.out.println(list);
		// 1. 세번째 강호동 삭제
		String kang = list.remove(2);
		System.out.println(kang + " 님이 삭제되셨습니다.");
		
		// 2. 2번째 데이터를 아이유로 수정
		list.set(1, "아이유");
		
		
		// 3, 탁제훈 앞에 김준호를 추가
		int idx = list.indexOf("탁제훈");
		list.add(idx-1, "김준호");
		
		// 4. 4번째 데이터를 받아서 출력
		System.out.println(list.get(3));
	}

}
