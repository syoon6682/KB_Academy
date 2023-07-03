package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
 * 1. Field initialization
 * 2. Method Calling
 */

public class NoteBookTest {

	public static void main(String[] args) {
		NoteBook n = new NoteBook();
		
		n.brand = "Samsung";
		n.price = 10000;
		n.serialNumber = 249380;
		
		n.printNoteBookInfo();

	}

}
