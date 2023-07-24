package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.util.MyDate;

public class InheritanceTest1 {

	public static void main(String[] args) {
		Manager m = new Manager("James", new MyDate(1990, 1, 1), 40000.0, "IT");
		Engineer e = new Engineer("James", new MyDate(1990, 1, 1), 40000.0, "Java", 30000.0);
		Secretary s = new Secretary("James", new MyDate(1990, 1, 1), 40000.0, "IT");
		
		System.out.println(m.getDetails());
		System.out.println(e);
		System.out.println(s);
	}

}
