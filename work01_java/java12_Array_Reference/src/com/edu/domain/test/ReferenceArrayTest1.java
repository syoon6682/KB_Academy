package com.edu.domain.test;

import com.edu.domain.NoteBook;

/*
 * Class Data Type의 배열을 생성, 초기화
 * Memory allocation
 */

public class ReferenceArrayTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// class data type의 초기값은 null
		NoteBook[] notebooks = new NoteBook[3];
		for(NoteBook nb: notebooks) System.out.println(nb);
		
		System.out.println("===========1============");
		
		notebooks[0] = new NoteBook("HP", 170, 123);
		notebooks[2] = new NoteBook("LG Gram", 130, 451);
		
		for(NoteBook nb: notebooks) System.out.println(nb);
		
		System.out.println("============2===========");
		
		for(NoteBook nb: notebooks) {
			if (nb == null) {
				continue;
			}
			System.out.println(nb.getNoteBookInfo());
		}
		
		System.out.println("============3===========");
		
		for(NoteBook nb: notebooks) {
			if (nb == null) {
				continue;
			}
			
			// 동일한 결과가 나옴 -> .toString이 생략되어있다.
			System.out.println(nb.toString());
			System.out.println(nb);
			// 그러나 toString은 NoteBook에 없다 -> 숨겨져 있다. -> 최상위인 Object Class에서 상속된 거
			
			
		}
		
	}

}
