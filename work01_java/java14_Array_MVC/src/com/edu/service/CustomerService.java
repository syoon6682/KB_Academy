package com.edu.service;

import com.edu.vo.Customer;
import com.edu.vo.Product;

/*
 * 아울렛에서 상품을 구매하는 고객에 대한 기능을 다루는 서비스 클래스...
 * 기능들만 정의되어져 있다.
 * 하나의 기능은 독자적인 완벽한 서비스로 이해하자.
 * 검색을 할때는 identifier keyword는 "find, search" 자주 활용!!
 */
public class CustomerService {
	// 1. 특정 고객이 구입한 상품을 리턴하는 기능...
	public Product[] getProducts(Customer c) {
		return c.getProducts();
	}
	
	// 2. 특정 고객이 구입한 상품들의 maker들만 리턴..
	public String[] getAllProductMaker(Customer c) {
		String[] temp = new String[c.getProducts().length];
		
		return temp;
	}
	
	/*
	 * Overloading을 활용하여 효율적인 identifier를 설정
	 * -> 진짜 직관성이 너무 좋은듯!
	 * 
	 * Method Overloading
	 * : 하나의 클래스에서 하는 일은 같지만 처리할 데이터를 달리할 때 쓰는 기법
	 * : SouceCode의 가독력을 높인다
	 * 
	 * 1. Method 이름은 일치!
	 * 2, arguments가 달라야함
	 * 3. return 타입은 상관없다.
	 * 
	 * 그러나 집중해야할 것은 Method의 전달력! 활용 잘하되 너무 얽매이지 말자.
	 */
	
	// 3. 모든 고객 중에서 특정한 고객을 검색...
	public Customer findCustomer(Customer[] custs, int ssn) {
		Customer customer = null;
		
		for(Customer c : custs) {
			if(c.getSsn() == ssn) {
				customer = c;
				break;
			}
		}
		
		return customer;
	}
	
	// 4. 모든 고객 중에서 특정한 동네 사는 고객을 검색...
	public Customer[] findCustomer(Customer[] custs, String v) {
		Customer[] customer = new Customer[custs.length];
		int idx = 0;
		for(Customer c : custs) {
			if(c.getAddress().equals(v)) {
				customer[idx++] = c;
			}
		}
		return customer;
	}
}
