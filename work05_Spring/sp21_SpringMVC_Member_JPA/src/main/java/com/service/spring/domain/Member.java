package com.service.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// vo class 

@Entity

// 얘랑 매핑되는 테이블 이름은 member다!
@Table(name="member")
public class Member {
	
	// PK 설정
	@Id
	@Column(name="id")
	private String id;
	
	// 붙이지 않으면 똑같이 맵핑된다.
	@Column(nullable=false) 
	private String password;
	
	@Column(length=30, nullable = false)
	private String name;
	
	@Column(length = 100)
	private String address;

	// 이 모든게 ORM 방식
	
	public Member(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	public Member() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
	
	
}
