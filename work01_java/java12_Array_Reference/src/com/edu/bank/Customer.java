package com.edu.bank;

public class Customer {
	private String custName;
	private int ssn;
	
	private Account[] accounts;
	
	
	public Customer(String custName, int ssn) {
		this.custName = custName;
		this.ssn = ssn;
	}
	

	public Account[] getAccounts() {
		return accounts;
	}


	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}


	// Getter and setter 
	public String getName() {
		return custName;
	}
	
	public void setName(String custName) {
		this.custName = custName;
	}
	
	public int getSsn() {
		return ssn;
	}
	
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	
	public String getCustomerInfo() {
		return ssn + "-" + custName;
	}
	
}
