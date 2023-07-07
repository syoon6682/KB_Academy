package com.edu.test;

import com.edu.vo.Product;

public class ProductArrayTest1 {

	public static void main(String[] args) {
		
		// 동종 데이터 타입이므로 Homogeneous Collection
		
		Product[] products = {
				new Product("신라면", 1200, 10, "농심"),
				new Product("삼다수", 1200, 2, "농심"),
				new Product("옥시크린", 34000, 1, "엘지"),
				new Product("I-Phone", 1000000, 1, "애플")
		}; 
		
		
		System.out.println("=== 1. 상품들의 Maker만 출력합니다 ===");
		for (Product prod : products ) {
			System.out.println(prod.getMaker());
		}
		
		System.out.println("=== 2. 10만원 이상의 고가제품 정보를 출력합니다. ===");
		for (Product prod : products ) {
			if (prod.getPrice() > 100000) {
				System.out.println(prod);
			}
		}
		
		
		System.out.println("=== 3. 구매한 상품의 총 합을 출력 ===");
		
		int totalSum = 0;
		for (Product prod : products ) {
			totalSum += prod.getPrice();
		}
		System.out.println(totalSum);
		
	}

}
