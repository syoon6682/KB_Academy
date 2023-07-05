package com.edu.oop.test;

import com.edu.oop.NoteBook;

public class NoteBookTest {

	public static void main(String[] args) {
		/*
		 * 1. 객체 생성 == class의 멤버를 메모리에 올린다.
		 * 2. 멤버에 접근
		 * 	  필드 --> 값할당
		 * 	  메소드 --> 호출
		 * Test 클래스에서는 이거 말고는 하면 안됨!
		 */
		NoteBook nb1 = new NoteBook("LG Gram", 170, 12);
		nb1.brand = "HP";
		System.out.println(nb1.getNoteBookInfo());

		NoteBook nb2 = new NoteBook();
		
	}

}
