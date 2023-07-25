package com.edu.test;

class Person{

	String name;
	

	public Person(String name) {
		super();
		this.name = name;
	}
	
	
}

public class StaticExamTest4 {
	static int counter;
	public static void main(String[] args) {
		Person p = new Person("James");
		System.out.println("James Person Instance Initilization");
	}
	
	static {
		counter++;
		System.out.println("static Initialization block.." + counter);
	}
}
