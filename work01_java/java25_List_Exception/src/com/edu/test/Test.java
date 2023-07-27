package com.edu.test;

public class Test {

	public static void main(String[] args) {
		String str1 = new String("JAVA");
		String str2 = new String("JAVA");
		
		//////////////////////////////////
		
		String str3 = "JAVA";
		String str4 = "JAVA";
		
		/*
		 * new로 올린 건 heap에 올라가고
		 * 그냥 선언하면 literal pool에 올라감
		 * -> 메모리에 올라가는 게 다름!
		 */
		
		System.out.println(str1 == str2);
		System.out.println(str3.equals(str4));
	}

}
