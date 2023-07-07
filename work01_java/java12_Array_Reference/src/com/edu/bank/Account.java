package com.edu.bank;
// 제어문 추가

/*
 * 1. 입금(deposit..)시 1천원 이상의 금액만 입금 / "입금액은 1천원 이상이어야 합니다." return
 * 2. 출금(withdraw..)시 잔액보다 더 큰 금액은 출금이 안되도록 / "출금액이 잔액보다 큽니다." 호출하기 전으로 return
 */
public class Account {
	private int accNumber;
	private double balance;
	private String bankName;
	
	
	// getter & setter
	
	public Account(int accNumber, double balance, String bankName) {
		this.accNumber = accNumber;
		this.balance = balance;
		this.bankName = bankName;
	}

	public String getAccountInfo() {
		return "Account Number: " + accNumber + "\n" 
				+ "Balance: " + balance + "\n" 
				+ "Bank name: " + bankName + "\n\n";
	}


	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
		
	
	// 나머지 기능을 추가...입금/츨금///제어문
	public void deposit(double amt) {
		if (amt < 1000.0) {
			System.out.println("입금액은 1천원 이상이어야 합니다.");
			return;
			
		} else {
		balance += amt;
		}
	}
	
	public void withdrawal(double amt) {
		if (amt > this.balance) {
			System.out.println("출금액이 잔액보다 큽니다.");
			return;
		} else {
		balance -= amt;
		}
	}
	
	@Override
	public String toString() {
		return accNumber+"-"+bankName+"-"+balance;
	}
}
