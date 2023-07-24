package com.edu.parent;

// 부모 클래스...

public class Parent {
	public String pulicVar = "publicVar";
	protected String protectedVar = "protectedVar";
	String var = "var";
	private String privateVar = "PrivateVar";
	
	public Parent() {}
	
	public void asess() {
		System.out.println("Access test...");
	}
}
