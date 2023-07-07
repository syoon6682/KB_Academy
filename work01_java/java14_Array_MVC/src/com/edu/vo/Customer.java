package com.edu.vo;
/*
 * Outlet 에서
 * 상품을 구입하는 고객에 대한 정보를 담고 있는 VO 클래스...
 */
public class Customer {
	private int ssn; // social security number : 주민번호
	private String name;
	private String address;	
	private Product[] products;
	
	public Customer(int ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	public int getSsn() {
		return ssn;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void changeAddress(String address) {
		this.address = address;
	}

	public Product[] getProducts() {
		return products;
	}

	public void buyProducts(Product[] products) {
		this.products = products;
	}
	
	public String getCustomerInfo() {
		return name + ", " + address;
	}
	
	
}
