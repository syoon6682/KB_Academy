package com.edu.test;

import com.edu.service.CustomerService;
import com.edu.vo.Customer;
import com.edu.vo.Product;

public class ProductArrayTest3 {

	public static void main(String[] args) {
		
		// 동종 데이터 타입이므로 Homogeneous Collection
		
		Product[] pros1 = {
				new Product("신라면", 1200, 10, "농심"),
				new Product("삼다수", 1200, 2, "농심"),
				new Product("옥시크린", 34000, 1, "엘지"),
				new Product("I-Phone", 1000000, 1, "애플")
		}; 
		
		Product[] pros2 = {
				new Product("새우깡", 1000, 10, "농심"),
				new Product("Terra", 5000, 2, "T"),
				new Product("정수기", 304000, 1, "엘지"),
		}; 
		
		Customer[] custs = {
				new Customer(111, "원빈", "방배동"),
				new Customer(222, "이나영", "방배동"),
		};
		
		custs[0].buyProducts(pros2);
		custs[1].buyProducts(pros1);
		
		
		CustomerService service = new CustomerService();
		
		Product[] p1 = service.getProducts(custs[0]);
		for(Product p : p1) {
			System.out.println(p);
		}
		
		System.out.println("========test1=========");
		System.out.println(service.findCustomer(custs, 111).getCustomerInfo());
		
		System.out.println("========test2=========");
		Customer[] searchedCust = service.findCustomer(custs, "방배동");
		for (Customer c : searchedCust) {
			System.out.println(c.getCustomerInfo());
		}
	}

}
