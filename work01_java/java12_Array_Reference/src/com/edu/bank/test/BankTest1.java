package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest1 {
	public static void main(String[] args) {
		/*
		 1. Account타입의 배열을 생성
		    111, 국민은행, 12만원
		    222, 신한은행, 340만원
		    333, 하나은행, 9만원
		 2. 김국민 이라는 고객이 1번에서 생성된 배열을 가짐
		    김국민에게는 국민은행, 신한은행, 하나은행 통장을 개설..
		    
		 3. 반복문을 사용해서 김국민이 개설한 통장의 정보를 출력
		 */
		//1.
		Account[ ] accounts  = {
				new Account(111, 120000.0, "국민은행"),
				new Account(222, 3400000.0, "신한은행"),
				new Account(333, 90000.0, "하나은행")				
		};
		
		//2.		
		Customer custom = new Customer("김국민", 123);	
		custom.setAccounts(accounts);
		
		//3.
		Account[ ] accs=custom.getAccounts();
		System.out.println("개설한 통장의 정보입니다.");
		
		for(Account acc : accs)
			System.out.println(acc);
		System.out.println("==========================");

		//1. 김국민이 개설한 통장중에서 국민은행 통장을 찾아서
		//   해당 통장의 잔액을 출금..
		System.out.println("=========개설한 통장중 국민은행 통장========");
		for(Account acc : accs) {
			if(acc.getBankName().equals("국민은행"))
				System.out.println(acc.getBalance());
		}
		
		//2. 김국민이 개설한 통장의 모든 잔액의 총합을 출력
		System.out.println("=========개설한 통장 총 잔액의 합========");
		int total = 0;
		for(Account acc : accs) {
			total += acc.getBalance();
		}
		System.out.println("총 잔액 : "+total);
		
		//3. 김국민이 개설한 통장중에서 가장 많은 잔액이 들어있는 
		//   통장의 이름과 해당 잔액을 출금
		System.out.println("=========개설한 통장 중 가장 잔액이 많은 통장========");
		double maxBalance = 0.0;
		String accName = null;
		for(Account acc : accs) {
			if(maxBalance < acc.getBalance()) {
				maxBalance = acc.getBalance();
				accName = acc.getBankName();
			}
		}
		System.out.println(accName+" :: "+maxBalance);
		
	}
}