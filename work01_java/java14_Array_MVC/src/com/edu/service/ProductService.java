package com.edu.service;

import com.edu.vo.Product;

/*
 * Product들을 관리하는 기능만으로 구성된 Service Class
 * 메소드 identifier / return 타입, 인자값
 * 메소드 하나당 서비스 하나 단위이다! 
 */

/*
 * convention
 * 출력은 print!, 리턴 get -> 이거는 꼭 넣기!
 * 비교는 more, less
 * private은 내부적으로 활용한다는 것을 의미함! 코드를 읽는 사람한테는 큰 도움이 됨!
 * 이런 convention과 틀을 짜는 걸 잘 알아두기!!!
 * 
 */

public class ProductService {
	// 1. 배열 안에 있는 모든 상품들의 메이커를 출력하는 기능 
	public void printAllProductMaker(Product[] pros) {
		for(Product p : pros) {
			System.out.println(p.getMaker());
		}
	}
	
	// 2. 상품들의 총 구입액을 리턴하는 기능
	public int getTotalPrice(Product[] pros) {
		int total = 0;
		for(Product p : pros) {
			total += p.getPrice()*p.getQuantity();
		}
		
		return total;
	}
	
	// 3. 특정 금액 이상의 상품을 리턴하는 기능
	public Product[] getMorePrice(Product[] pros, int price) {
		Product [] temp = new Product[pros.length];
		int idx = 0;
		for(Product p : pros) {
			if (p.getPrice() > price) {
				temp[idx++] = p;	
			}
		}
		return temp; 
	}
	
	// 4. 동일한 회사의 제품들만 리턴하는 기능
	public Product[] getCertainCompany(Product[] pros, String company) {
		Product [] temp = new Product[pros.length];
		int idx = 0;
		for(Product p : pros) {
			if (p.getCompany().equals(company)) {
				temp[idx++] = p;	
			}
		}
		return temp; 
	}
	
	// 5. 구입한 상품들의 평균 가격을 리턴하는 기능
	// 상위에 getTotalPrice를 활용하기 -> 이때 위쪽에 getTotalPrice를 정의해줘야함
	public int getAvgPrice(Product[] pros) {
		return getTotalPrice(pros)/pros.length;
	}
	
	
	
}
