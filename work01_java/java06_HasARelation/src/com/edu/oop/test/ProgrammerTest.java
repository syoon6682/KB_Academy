package com.edu.oop.test;
import com.edu.oop.Programmer;
import com.edu.oop.NoteBook;


public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		 * 1. 객체 생성
		 * 2. 기능을 호출
		 * -------------------------
		 * 1. James라는 개발자를 생성
		 * 	  정보를 입력...이름, 주요기술, 급여
		 * 2. James가 HP 노트북을 구매...setter주입
		 * 3. James가 구매한 노트북을 리턴받아서 노트북의 정보를 출력
		 * 4. James의 변경된 mainSkill, 급여를 출력
		 */
		Programmer tester = new Programmer("James", "Java", 1000000);
		tester.buyNoteBook(new NoteBook("HP", 200000, 1234));
		System.out.println(tester.getNoteBook().getNoteBookInfo());
		
		tester.changeMainSkill("Python");
		System.out.println(tester.getMainSkill());
		tester.incrementSalary(3000);
		System.out.println(tester.getSalary());
	}

}
