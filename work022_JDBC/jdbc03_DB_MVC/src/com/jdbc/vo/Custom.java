package com.jdbc.vo;

/*
 * Custom 테이블의 정보를 저장하는 클래스
 * Value Object
 * 
 * Custom 테이블의 컬럼이 클래스의 필드
 * 
 */

public class Custom {
	private int id;
	private String name;
	private String address;
	public Custom(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Custom() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
