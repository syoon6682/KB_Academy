package com.edu.oop;

public class Programmer {
	
	// 생성자 주입
	public String name;
	public String mainSkill;
	public int salary;
	
	
	// setter 주입
	///////// Has a Realation /////////
	public NoteBook noteBook;


	public Programmer(String name, String mainSkill, int salary) {
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
	}


	public String getMainSkill() {
		return mainSkill;
	}


	public void changeMainSkill(String mainSkill) {
		this.mainSkill = mainSkill;
	}


	public NoteBook getNoteBook() {
		return noteBook;
	}


	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	
	// 기능 추가...
	public int annualSalary() {
		return salary * 12;
	}
	
	public void incrementSalary(int amt) {
		salary += amt; // same as python
	}


	public int getSalary() {
		return salary;
	}
	
	
	
}
